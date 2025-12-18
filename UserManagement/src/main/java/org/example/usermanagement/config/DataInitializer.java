package org.example.usermanagement.config;

import lombok.RequiredArgsConstructor;
import org.example.usermanagement.model.Role;
import org.example.usermanagement.repository.RoleRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String @NonNull ... args) {
        initializeDefaultRoles();
    }

    private void initializeDefaultRoles() {
        createRoleIfNotExists("USER", "Basic user with limited access");
        createRoleIfNotExists("MODERATOR", "Moderator with intermediate permissions");
        createRoleIfNotExists("ADMIN", "Administrator with full access");

        log.info("Default roles verification completed");
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
}
