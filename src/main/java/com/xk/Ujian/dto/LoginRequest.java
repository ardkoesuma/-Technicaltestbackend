package com.xk.Ujian.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank; 



public class LoginRequest {
    
    
    @NotBlank(message = "Password harus diisi") 
    private String password;

    @NotBlank(message = "Email harus diisi")
    @Email(message = "Email should be valid")
    private String email;
 

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
