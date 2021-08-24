package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.ProfessionalNotFoundException;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.repository.ProfessionalRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessionalController {
    private final ProfessionalRepository repository;

    ProfessionalController(ProfessionalRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/professionals")
    Professional newProfessional(@RequestBody Professional newProfessional) { return repository.save(newProfessional); }

    @GetMapping("/professionals")
    List<Professional> get_All() { return repository.findAll(); }

    @GetMapping("/professionals/{id}")
    Professional get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundException(id));
    }

    @PutMapping("/professionals/{id}")
    Professional replaceProfessional(@RequestBody Professional newProfessional, @PathVariable Long id){

        return repository.findById(id)
                .map(professional -> {
                    professional.setUsername(newProfessional.getUsername());
                    professional.setPassword(newProfessional.getPassword());
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

