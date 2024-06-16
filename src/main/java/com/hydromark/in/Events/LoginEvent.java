package com.hydromark.in.Events;

import org.springframework.context.ApplicationEvent;

import java.security.Principal;

public class LoginEvent extends ApplicationEvent {
    Principal principal;
    public LoginEvent(Object source, Principal principal) {
        super(source);
        this.principal = principal;
    }
}
