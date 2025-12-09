package com.webapp.webapp_be.controllers;

import com.webapp.webapp_be.dto.UserDTO;
import com.webapp.webapp_be.models.User;
import com.webapp.webapp_be.response.AuthResponse;
import com.webapp.webapp_be.services.users.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            User newUser = userService.Register(userDTO);
            return ResponseEntity.ok(newUser);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserDTO userDTO) {
        try {
            AuthResponse login = userService.Login(userDTO.getUserName(), userDTO.getPassword());
            return ResponseEntity.ok(login);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    AuthResponse.builder()
                            .message("Login failed: " + e.getMessage())
                            .build()
            );
        }
    }
}
