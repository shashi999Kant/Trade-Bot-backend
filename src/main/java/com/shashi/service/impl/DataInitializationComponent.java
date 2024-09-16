package com.shashi.service.impl;


import com.shashi.domain.USER_ROLE;
import com.shashi.model.User;
import com.shashi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializationComponent implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    public DataInitializationComponent(UserRepository userRepository,
//                                       PasswordEncoder passwordEncoder
//                                       ) {
//        this.userRepository = userRepository;
//        this.passwordEncoder=passwordEncoder;
//
//    }

    @Override
    public void run(String... args) {
        initializeAdminUser();
    }

    private void initializeAdminUser() {
        String adminUsername = "shashibabu6390@gmail.com";

        if (userRepository.findByEmail(adminUsername)==null) {
            User adminUser = new User();

            adminUser.setPassword(passwordEncoder.encode("Shashi@123"));
            adminUser.setFullName("Shashi kant Tiwari");
            adminUser.setEmail(adminUsername);
            adminUser.setRole(USER_ROLE.ROLE_ADMIN);
            User admin=userRepository.save(adminUser);
        }
    }

}
