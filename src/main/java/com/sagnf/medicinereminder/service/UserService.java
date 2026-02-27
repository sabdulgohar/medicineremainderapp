package com.sagnf.medicinereminder.service;

import com.sagnf.medicinereminder.dto.RegisterRequest;
import com.sagnf.medicinereminder.entity.User;
import com.sagnf.medicinereminder.repository.UserRepository;
import com.sagnf.medicinereminder.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sagnf.medicinereminder.dto.RegisterRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPassword(passwordEncoder.encode(request.getPassword()));// Next step we encrypt
        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }
    // ================= LOGIN =================
    public String login(String username, String password) {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Invalid credentials");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(username);
    }


}