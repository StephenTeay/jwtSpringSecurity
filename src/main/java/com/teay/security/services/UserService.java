package com.teay.security.services;

import com.teay.security.dtos.UserRequest;
import com.teay.security.models.Users;
import com.teay.security.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JWTServiceImpl jwtService;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder,
                       AuthenticationManager authenticationManager, JWTServiceImpl jwtService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public Users registerUser (UserRequest request) throws Exception {
        Users newUser = new Users(request);
        newUser.setPassword(encoder.encode(request.getPassword()));
        userRepository.save(newUser);
        return newUser;
    }

    public String verifyUser(UserRequest request){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(request.getUsername());
        return "false";

    }
}
