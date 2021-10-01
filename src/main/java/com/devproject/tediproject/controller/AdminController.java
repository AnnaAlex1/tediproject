package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.AdminNotFoundException;
import com.devproject.tediproject.model.Admin;
import com.devproject.tediproject.model.User;
import com.devproject.tediproject.repository.AdminRepository;

import com.devproject.tediproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    private final AdminRepository repository;

    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AdminController(AdminRepository repository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/admins/add")
    Admin newAdmin(@RequestBody Admin newAdmin) {
        User user = new User(newAdmin.getUsername(), newAdmin.getPassword(), newAdmin);
        userRepository.save(user);
        return repository.save(newAdmin);
    }

    @GetMapping("/admins/all")
    List<Admin> get_All() { return repository.findAll(); }

    @GetMapping("/admins/{id}")
    Admin get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException(id));
    }

    @PutMapping("/admins/update/{id}")
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

    @DeleteMapping("/admins/delete/{id}")
    void deleteAdmin(@PathVariable Long id) { repository.deleteById(id); }

}
