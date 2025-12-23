package org.example.usermanagement.dto.response;

public record AuthResponse(
        String token,
        String type,
        String username,
        String email,
        String role
) {

    private static final String TYPE = "Bearer";

    public AuthResponse(
            String token,
            String username,
            String email,
            String role) {
        this(token, TYPE, username, email, role);
    }
}
