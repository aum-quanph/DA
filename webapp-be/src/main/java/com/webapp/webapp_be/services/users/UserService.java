package com.webapp.webapp_be.services.users;
import com.webapp.webapp_be.component.JwtTokenUtil;
import com.webapp.webapp_be.dto.UserDTO;
import com.webapp.webapp_be.exceptions.FieldValidationException;
import com.webapp.webapp_be.models.User;
import com.webapp.webapp_be.repository.UserRepository;
import com.webapp.webapp_be.response.AuthResponse;
import com.webapp.webapp_be.response.UserResponseDTO;
import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public User Register(UserDTO userDTO) {
        if (userRepository.existsByUserName(userDTO.getUserName())) {
            throw new FieldValidationException("username", "Tên người dùng đã tồn tại!");
        }

        if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber())) {
            throw new FieldValidationException("phone_number", "Số điện thoại đã tồn tại!");
        }

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new FieldValidationException("email", "Email đã tồn tại!");
        }

        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            throw new FieldValidationException("confirm_password", "Xác nhận mật khẩu không khớp!");
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
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(), password, user.getAuthorities());
        authenticationManager.authenticate(authenticationToken);

        String token = jwtTokenUtil.generateToken(user);
        UserResponseDTO userResponse = UserResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUsername())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .dateOfBirth(user.getDateOfBirth())
                .build();

        return AuthResponse.builder()
                .user(userResponse)
                .token(token)
                .message("Login successful")
                .build();
    }
}

