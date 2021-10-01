package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.ProfessionalNotFoundException;
import com.devproject.tediproject.exception.ProfessionalNotFoundExceptionWithoutId;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.model.User;
import com.devproject.tediproject.payload.ProfessionalAddRequest;
import com.devproject.tediproject.payload.ProfessionalSignInRequest;
import com.devproject.tediproject.payload.ProfessionalUpdateSettings;
import com.devproject.tediproject.repository.ProfessionalRepository;

import com.devproject.tediproject.repository.UserRepository;
import com.devproject.tediproject.security.JwtAuthenticationResponse;
import com.devproject.tediproject.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class ProfessionalController {
    private final ProfessionalRepository repository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;


    public ProfessionalController(ProfessionalRepository repository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @PostMapping("/professionals/add")
//    Professional newProfessional(@RequestBody ProfessionalAddRequest newProfessionalRequest) {
//
//        Professional newProfessional = new Professional(newProfessionalRequest);
//        newProfessional.setPassword(passwordEncoder.encode(newProfessional.getPassword()));
//
//        User user = new User(newProfessionalRequest.getUsername(), newProfessionalRequest.getPassword(), newProfessional);
//        userRepository.save(user);
//
//        return repository.save(newProfessional);
//
//    }


    @PostMapping("/professionals/add")
    public ResponseEntity<Professional> newProfessional(@RequestBody ProfessionalAddRequest newProfessionalRequest) {

        Professional newProfessional = new Professional(newProfessionalRequest);
        newProfessional.setPassword(passwordEncoder.encode(newProfessional.getPassword()));

        repository.save(newProfessional);

        User user = new User(newProfessional.getUsername(), newProfessional.getPassword(), newProfessional);
        userRepository.save(user);


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.AUTHORIZATION,
                        tokenProvider.generateToken(authentication)
                ).body(newProfessional);

    }

    @GetMapping("/professionals/all")
    List<Professional> get_All() { return repository.findAll(); }

    @GetMapping("/professionals/{id}/following")
    List<Professional> getFollowing(@PathVariable Long id){ return repository.getFollowing(id);}

    @GetMapping("/professionals/{id}/nonfollowing")
    List<Professional> getNonFollowing(@PathVariable Long id){ return repository.getAllExceptFriends(id);}


    @GetMapping("/professionals/{id}")
    Professional get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundException(id));
    }

/*    @GetMapping("/professionals/login")
    Professional get_one(@RequestBody ProfessionalSignInRequest newSignInRequest){
        return repository.findProfessionalByEmailAndPassword(newSignInRequest.getEmail(),newSignInRequest.getPassword());
//        return repository.findProfessionalByEmailAndPassword(newSignInRequest);
    }*/



//    @GetMapping("/professionals/login")
//    Professional get_one(@RequestBody ProfessionalSignInRequest newSignInRequest){
//        Professional prof = repository.findProfessionalByEmailAndPassword(newSignInRequest.getEmail(),newSignInRequest.getPassword());
//        if (prof!=null) {
////            prof.setMessageList(null);
//            prof.setPostList(null);
//            return prof;
//        }
//        throw new ProfessionalNotFoundExceptionWithoutId();
//
//        /*ProfessionalSignInRequest result = new ProfessionalSignInRequest();
//        result.setEmail(prof.getEmail());
//        result.setPassword(prof.getPassword());
//        return result;*/
//    }


    @PutMapping("/professionals/{id}")
    Professional replaceProfessional(@RequestBody Professional newProfessional, @PathVariable Long id){

        return repository.findById(id)
                .map(professional -> {
                    professional.setId(newProfessional.getId());
                    professional.setUsername(newProfessional.getUsername());
                    professional.setPassword(newProfessional.getPassword());
                    professional.setName(newProfessional.getName());
                    professional.setSurname(newProfessional.getSurname());
                    professional.setEmail(newProfessional.getEmail());
                    professional.setPhone(newProfessional.getPhone());
                    professional.setPicture_url(newProfessional.getPicture_url());
                    professional.setName_surname_public(newProfessional.getName_surname_public());
                    professional.setEmail_public(newProfessional.getEmail_public());
                    professional.setPhone_public(newProfessional.getPhone_public());
                    professional.setWork_position(newProfessional.getWork_position());
                    professional.setWork_place(newProfessional.getWork_place());

                    return repository.save(professional);
                })
                .orElseGet(() -> {
                    newProfessional.setId(id);
                    return repository.save(newProfessional);
                });
    }

    @PutMapping("/professionals/settings/{id}/update")
    Professional updateProfessionalSettings(@RequestBody ProfessionalUpdateSettings newProfessional, @PathVariable Long id){

        return repository.findById(id)
                .map(professional -> {
                    professional.setEmail(newProfessional.getEmail());
                    professional.setPassword(newProfessional.getPassword());
                    professional.setUsername(newProfessional.getEmail());

                    repository.save(professional);

//                    professional.setMessageList(null);
                    professional.setPostList(null);

                    return professional;
                })
                .orElseGet(() -> {
                    /*newProfessional.setId(id);
                    return repository.save(newProfessional);*/
                    throw new ProfessionalNotFoundException(id);
                });
    }

    @DeleteMapping("/professionals/{id}")
    void deleteProfessional(@PathVariable Long id) { repository.deleteById(id); }

}

