package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.account.AccountType;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenEntityStub {
    public static TokenEntity create() {
        return TokenEntity.builder()
                .tokenId(UUID.randomUUID().toString())
                .tokenValue(TOKEN_VALUE_STUB)
                .userEmailAddress(TUTOR_EMAIL_ADDRESS_STUB)
                .accountType(AccountType.TUTOR)
                .rsaPublicKey(RSA_PUBLIC_KEY_STUB)
                .creationDateTime(LocalDateTime.now())
                .expirationDateTime(LocalDateTime.now().plusHours(1))
                .build();
    }

    public static TokenEntity create(LocalDateTime expirationDateTime, LocalDateTime revocationDateTime) {
        TokenEntity token = create();
        token.setCreationDateTime(expirationDateTime.minusHours(1));
        token.setExpirationDateTime(expirationDateTime);
        token.setRevocationDateTime(revocationDateTime);
        return token;
    }
}
