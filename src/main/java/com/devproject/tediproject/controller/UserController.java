package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.UserNotFoundException;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.model.User;
import com.devproject.tediproject.repository.UserRepository;
import com.devproject.tediproject.security.JwtAuthenticationResponse;
import com.devproject.tediproject.security.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository repository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;



    public UserController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


/*
        @GetMapping("/professionals/login")
        Professional get_one(@RequestBody ProfessionalSignInRequest newSignInRequest){
            Professional prof = repository.findProfessionalByEmailAndPassword(newSignInRequest.getEmail(),newSignInRequest.getPassword());
            if (prof!=null) {
//            prof.setMessageList(null);
                prof.setPostList(null);
                return prof;
            }
            throw new ProfessionalNotFoundExceptionWithoutId();
*/
        /*ProfessionalSignInRequest result = new ProfessionalSignInRequest();
        result.setEmail(prof.getEmail());
        result.setPassword(prof.getPassword());
        return result;
        }
        */

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);



//    @PostMapping(path="/login")
//    public @ResponseBody JwtAuthenticationResponse authorizeUser(@RequestBody User userToLogin) {
//
//
//        Optional<User> res = repository.findByUsername(userToLogin.getUsername());
//        if(!res.isPresent()){
//            throw new UserNotFoundException();
//        }
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        userToLogin.getUsername(),
//                        userToLogin.getPassword()
//                )
//        );
//
//
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = tokenProvider.generateToken(authentication);
//        return new JwtAuthenticationResponse(jwt);
//    }


    @PostMapping(path="/login")
    public ResponseEntity<User>  authorizeUser(@RequestBody User userToLogin) {

        Optional<User> res = repository.findByUsername(userToLogin.getUsername());
        if(!res.isPresent()){
            throw new UserNotFoundException();
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userToLogin.getUsername(),
                        userToLogin.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.AUTHORIZATION,
                        tokenProvider.generateToken(authentication)
                ).body(res.get());
    }

}
