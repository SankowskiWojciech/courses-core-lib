package com.github.sankowskiwojciech.coursescorelib.model.db.login;

import com.github.sankowskiwojciech.coursescorelib.model.account.AccountType;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "LOGIN_CREDENTIALS")
@EqualsAndHashCode
public class LoginCredentialsEntity {
    @Id
    @Column(name = "USER_EMAIL_ADDRESS", length = 50, unique = true, nullable = false, updatable = false)
    private String userEmailAddress;

    @Column(name = "PASSWORD_HASH", length = 60, nullable = false)
    private String passwordHash;

    @Column(name = "ACCOUNT_TYPE", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
