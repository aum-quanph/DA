package com.webapp.webapp_be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;

@Data
public class UserDTO {
    @JsonProperty("username")
    private String userName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    private String password;
}
