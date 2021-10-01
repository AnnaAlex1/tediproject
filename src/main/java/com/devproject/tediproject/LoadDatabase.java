package com.devproject.tediproject;

import com.devproject.tediproject.model.Admin;
import com.devproject.tediproject.model.User;
import com.devproject.tediproject.repository.AdminRepository;
import com.devproject.tediproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
class LoadDatabase {

    private final PasswordEncoder passwordEncoder;

    public LoadDatabase(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initDatabase(AdminRepository repository, UserRepository userRepository) {
        return args -> {

            String username = "admin"; String password =  passwordEncoder.encode("adminpass");
            Admin admin = new Admin(username, password);

            log.info("Preloading " + repository.save(admin));
            userRepository.save(new User(username, password, admin));

        };
    }
}
