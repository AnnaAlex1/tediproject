package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.CompanyNotFoundException;
import com.devproject.tediproject.model.Company;
import com.devproject.tediproject.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyRepository repository;

    public CompanyController(CompanyRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/companies")
    Company newCompany(@RequestBody Company newCompany) { return repository.save(newCompany); }

    @GetMapping("/companies")
    List<Company> get_All() { return  repository.findAll(); }

    @GetMapping("/companies/{name}")
    Company get_one(@PathVariable String name){
        return repository.findById(name)
                .orElseThrow(() -> new CompanyNotFoundException(name));
    }

    @PutMapping("/companies/{name}")
    Company replaceCompany(@RequestBody Company newCompany, @PathVariable String name){
        return repository.findById(name)
                .map( company -> {
                    company.setName(newCompany.getName());
                    return repository.save(company);
                })
                .orElseGet( () -> {
                    newCompany.setName(name);
                    return repository.save((newCompany));
                });
    }

    @DeleteMapping("/companies/{name}")
    void deleteCompany(@PathVariable String name) { repository.deleteById(name);}

}
