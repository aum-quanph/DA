package com.webapp.webapp_be.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webapp.webapp_be.dto.UserDTO;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    @JsonProperty("token")
    private String token;

    @JsonProperty("user")
    private UserDTO user;

    private String message;
}
