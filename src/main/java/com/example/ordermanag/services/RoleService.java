package com.example.ordermanag.services;

import com.example.ordermanag.entities.Role;
import com.example.ordermanag.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initRoles() {
        if (roleRepository.findByName("User").isEmpty()) {
            Role userRole = new Role();
            userRole.setName("User");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName("Admin").isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName("Admin");
            roleRepository.save(adminRole);
        }
    }
}
