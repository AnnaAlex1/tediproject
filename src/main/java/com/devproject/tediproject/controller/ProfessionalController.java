package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.ProfessionalNotFoundException;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.repository.ProfessionalRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
public class ProfessionalController {
    private final ProfessionalRepository repository;

    ProfessionalController(ProfessionalRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/professionals")
    Professional newProfessional(@RequestBody Professional newProfessional) { return repository.save(newProfessional); }

    @GetMapping("/professionals/all")
    List<Professional> get_All() { return repository.findAll(); }

    @GetMapping("/professionals/{id}/following")
    List<Professional> getFollowing(@PathVariable Long id){ return repository.getFollowing(id);}

    @GetMapping("/professionals/{id}")
    Professional get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundException(id));
    }

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

    @DeleteMapping("/professionals/{id}")
    void deleteProfessional(@PathVariable Long id) { repository.deleteById(id); }

}

