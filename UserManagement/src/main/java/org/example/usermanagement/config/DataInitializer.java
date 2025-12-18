package org.example.usermanagement.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import org.jspecify.annotations.NonNull;

import org.example.usermanagement.model.Role;
import org.example.usermanagement.model.User;
import org.example.usermanagement.repository.RoleRepository;
import org.example.usermanagement.repository.UserRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String @NonNull ... args) {
        initializeDefaultRoles();
        initializeDefaultUsers();
    }

    private void initializeDefaultRoles() {
        createRoleIfNotExists("USER", "Basic user with limited access");
        createRoleIfNotExists("MODERATOR", "Moderator with intermediate permissions");
        createRoleIfNotExists("ADMIN", "Administrator with full access");

        log.info("Default roles verification completed");
    }

    private void initializeDefaultUsers() {
        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new RuntimeException("Admin role not found"));
        Role moderatorRole = roleRepository.findByName("MODERATOR")
                .orElseThrow(() -> new RuntimeException("Moderator role not found"));
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("User role not found"));

        createUserIfNotExists("admin", "admin@example.com", "admin123", adminRole);
        createUserIfNotExists("moderator", "moderator@example.com", "mod123", moderatorRole);
        createUserIfNotExists("user", "user@example.com", "user123", userRole);

        log.info("Default users verification completed");
    }

    private void createRoleIfNotExists(String name, String description) {
        if (!roleRepository.existsByName(name)) {
            roleRepository.save(Role.builder()
                    .name(name)
                    .description(description)
                    .build());
            log.info("Created role: {}", name);
        }
    }

    private void createUserIfNotExists(String username,String email, String password, Role role){
        if (!userRepository.existsByUsername(username)){
            userRepository.save(User.builder()
                    .username(username)
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .role(role)
                    .isActive(true)
                    .build());
            log.info("Created user: {} with role: {}", username, role.getName());
        }
    }
}
