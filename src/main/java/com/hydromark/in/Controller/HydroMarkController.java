package com.hydromark.in.Controller;

import com.hydromark.in.DTO.Users;
import com.hydromark.in.Events.LoginEvent;
import com.hydromark.in.Repository.UserRepository;
import com.hydromark.in.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HydroMarkController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/enquiry")
    public String enquiry(Principal principal) throws Exception {
        userService.createUser(principal);
        return "enquiry";
    }

    @RequestMapping("/internal")
    public String addProducts() {
        return "internal";
    }


}
