package com.webapp.webapp_be.services;

import com.webapp.webapp_be.dto.UserDTO;
import com.webapp.webapp_be.models.User;
import com.webapp.webapp_be.response.AuthResponse;

public interface IUserService {
    AuthResponse Login(String username, String password) throws Exception;
    User Register(UserDTO userDTO);
}
