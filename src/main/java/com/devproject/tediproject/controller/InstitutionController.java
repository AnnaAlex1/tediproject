package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Company;
import com.devproject.tediproject.model.Institution;
import com.devproject.tediproject.repository.InstitutionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitutionController {

    private final InstitutionRepository repository;

    public InstitutionController(InstitutionRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/institutions")
    Institution newInstitution(@RequestBody Institution newInstitution) { return repository.save(newInstitution); }

    @GetMapping("/institutions")
    List<Institution> get_All() { return repository.findAll(); }



    @PutMapping("/institutions/{name}")
    Institution replaceInstitution(@RequestBody Institution newInstitution, @PathVariable String name){
        return repository.findById(name)
                .map( institution -> {
                    institution.setName(newInstitution.getName());
                    return repository.save(institution);
                })
                .orElseGet( () -> {
                    newInstitution.setName(name);
                    return repository.save((newInstitution));
                });
    }

    @DeleteMapping("/institutions/{name}")
    void deleteInstitution(@PathVariable String name) { repository.deleteById(name);}
}
