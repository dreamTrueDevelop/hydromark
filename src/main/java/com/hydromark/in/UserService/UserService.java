package com.hydromark.in.UserService;

import com.hydromark.in.DTO.Users;
import com.hydromark.in.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findById(userName);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(userName);
        }
        return User.builder()
                .username(user.get().getUserName())
                .password((user.get().getPwd()))
                .build();
    }

    public void createUser(Principal principal) throws Exception {
        String username = (String) ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("name");
        String email = (String) ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("email");
        Optional<Users> user = userRepository.findById(username);
        if (!user.isPresent()) {
            userRepository.save(new Users(username, email, "USER"));
        } else {
            log.info("Creating user skipped - user already found");
        }
    }
}
