package com.hydromark.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class Users {
    @Id
    private String userName;
    private String pwd;
    private String Role;
}
