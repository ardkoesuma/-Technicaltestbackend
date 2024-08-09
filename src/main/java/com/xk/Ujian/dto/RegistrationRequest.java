package com.xk.Ujian.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class RegistrationRequest {

    @NotBlank(message = "Username harus diisi")
    @Size(min = 3, max = 20, message = "Username harus 3 - 20 karakter")
    private String username;

    @NotBlank(message = "Password harus diisi")
    @Size(min = 6, message = "Password minimal 6 karakter")
    private String password;

    @NotBlank(message = "Email harus diisi")
    @Email(message = "Email should be valid")
    private String email;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
