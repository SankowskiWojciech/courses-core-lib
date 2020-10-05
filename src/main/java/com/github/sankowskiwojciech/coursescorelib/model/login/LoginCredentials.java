package com.github.sankowskiwojciech.coursescorelib.model.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginCredentials {
    private String userEmailAddress;
    private String password;
}
