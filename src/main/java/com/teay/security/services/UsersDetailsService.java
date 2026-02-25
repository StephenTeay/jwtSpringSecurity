package com.teay.security.services;

import com.teay.security.models.UserPrincipal;
import com.teay.security.models.Users;
import com.teay.security.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UsersDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new UserPrincipal(user.get());
        }
        throw new UsernameNotFoundException("User not found");
    }


}
