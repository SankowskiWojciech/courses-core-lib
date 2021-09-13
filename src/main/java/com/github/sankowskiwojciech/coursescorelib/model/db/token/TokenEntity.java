package com.github.sankowskiwojciech.coursescorelib.model.db.token;

import com.github.sankowskiwojciech.coursescorelib.model.account.AccountType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TOKEN")
@EqualsAndHashCode
public class TokenEntity {
    @Id
    @Column(name = "TOKEN_ID", length = 36, nullable = false, unique = true, updatable = false)
    private String tokenId;

    @Setter
    @Column(name = "TOKEN_VALUE", length = 354, nullable = false, updatable = false)
    private String tokenValue;

    @Column(name = "USER_EMAIL_ADDRESS", length = 50, nullable = false, updatable = false)
    private String userEmailAddress;

    @Column(name = "ACCOUNT_TYPE", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "RSA_PUBLIC_KEY", length = 212, nullable = false, updatable = false)
    private String rsaPublicKey;

    @Column(name = "CREATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;

    @Column(name = "EXPIRATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime expirationDateTime;

    @Column(name = "REVOCATION_DATE_TIME")
    private LocalDateTime revocationDateTime;
}
