package com.sagnf.medicinereminder.dto;

import com.sagnf.medicinereminder.dto.RegisterRequest;
import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String username;
    private String password;
}
