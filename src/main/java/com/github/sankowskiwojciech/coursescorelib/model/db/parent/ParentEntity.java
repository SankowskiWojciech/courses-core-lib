package com.github.sankowskiwojciech.coursescorelib.model.db.parent;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PARENT")
@EqualsAndHashCode
public class ParentEntity {
    @Id
    @Column(name = "EMAIL_ADDRESS", length = 50, unique = true, nullable = false, updatable = false)
    private String emailAddress;

    @Column(name = "FIRST_NAME", length = 15, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;

    @Column(name = "PHONE_NUMBER", length = 9)
    private String phoneNumber;
}
