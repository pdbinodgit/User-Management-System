package com.usermanagementsystem.usermanagementsystem.config;

import com.usermanagementsystem.usermanagementsystem.user.model.User;
import com.usermanagementsystem.usermanagementsystem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/url")
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
        User user=userRepository.findByEmail(authRequest.getUsername());
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credential.");
        }
        String token=jwtService.generateToken(authRequest.getUsername());
        return new AuthResponse(token);
    }
}
