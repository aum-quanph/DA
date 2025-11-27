package com.webapp.webapp_be.services;
import com.webapp.webapp_be.dto.UserDTO;
import com.webapp.webapp_be.models.User;
import com.webapp.webapp_be.repository.UserRepository;
import com.webapp.webapp_be.response.AuthResponse;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User Register(UserDTO userDTO) {
        if(userRepository.existsByUserName(userDTO.getUserName())) {
            throw new RuntimeException("Username đã tồn tại!");
        }
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            throw new RuntimeException("Xác nhận mật khẩu không khớp!");
        }
        User newUser = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .dateOfBirth(userDTO.getDateOfBirth())
                .build();
        // mã hóa
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        newUser.setPassword(encodedPassword);
        return userRepository.save(newUser);
    }

    @Override
    public AuthResponse Login(String username, String password) throws Exception {

//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new BadCredentialsException("Invalid credentials");
//        }
    }
}

