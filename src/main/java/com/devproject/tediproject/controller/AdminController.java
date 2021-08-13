package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.AdminNotFoundException;
import com.devproject.tediproject.model.Admin;
import com.devproject.tediproject.repository.AdminRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    private final AdminRepository repository;

    AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/admins")
    Admin newAdmin(@RequestBody Admin newAdmin) { return repository.save(newAdmin); }

    @GetMapping("/admins")
    List<Admin> get_All() { return repository.findAll(); }

    @GetMapping("/admins/{id}")
    Admin get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException(id));
    }

    @PutMapping("/admins/{id}")
    Admin replaceAdmin(@RequestBody Admin newAdmin, @PathVariable Long id){

        return repository.findById(id)
                .map(admin -> {
                    admin.setUsername(newAdmin.getUsername());
                    admin.setPassword(newAdmin.getPassword());
                    return repository.save(admin);
                })
                .orElseGet(() -> {
                    newAdmin.setId(id);
                    return repository.save(newAdmin);
                });
    }

    @DeleteMapping("/admins/{id}")
    void deleteAdmin(@PathVariable Long id) { repository.deleteById(id); }

}
