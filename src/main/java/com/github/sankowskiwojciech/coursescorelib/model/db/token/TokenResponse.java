package com.github.sankowskiwojciech.coursescorelib.model.db.token;

import com.github.sankowskiwojciech.coursescorelib.model.account.AccountType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class TokenResponse {
    private final String tokenValue;
    private final AccountType accountType;
    private final LocalDateTime expirationDateTime;
}

