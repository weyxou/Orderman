package com.example.ordermanag.controllers;

import com.example.ordermanag.entities.Role;
import com.example.ordermanag.entities.User;
import com.example.ordermanag.repository.RoleRepository;
import com.example.ordermanag.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public ResponseEntity<String> registerNewUser(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null || user.getName() == null) {
            return ResponseEntity.badRequest().body("All fields (username, password, name) are required.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            for (Role role : user.getRoles()) {
                Role existingRole = roleRepository.findByName(role.getName()).orElse(null);
                if (existingRole != null) {
                    roles.add(existingRole);
                } else {
                    return ResponseEntity.badRequest().body("Role " + role.getName() + " not found.");
                }
            }
        } else {
            Role userRole = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Default role USER not found"));
            roles.add(userRole);
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered");
    }


    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
