package org.example.usermanagement.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.example.usermanagement.dto.request.LoginRequest;
import org.example.usermanagement.dto.request.RegisterRequest;
import org.example.usermanagement.dto.response.AuthResponse;
import org.example.usermanagement.model.Role;
import org.example.usermanagement.model.User;
import org.example.usermanagement.repository.RoleRepository;
import org.example.usermanagement.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthResponse register(RegisterRequest request) {

        String username = request.username().trim().toLowerCase();
        String email = request.email().trim().toLowerCase();

        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        // We ignore the role they send and force USER.
        Role role = roleRepository.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("Default role not found"));

        User user = User.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(request.password()))
                .role(role)
                .isActive(true)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getUsername(), user.getEmail(), user.getRole().getName());
    }

    public AuthResponse login(LoginRequest request) {

        String username = request.username().trim().toLowerCase();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, request.password())
        );

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, user.getUsername(), user.getEmail(), user.getRole().getName());
    }

}
