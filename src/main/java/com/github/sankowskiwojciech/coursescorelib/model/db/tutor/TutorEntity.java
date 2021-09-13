package com.github.sankowskiwojciech.coursescorelib.model.db.tutor;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TUTOR")
@EqualsAndHashCode(exclude = "individualLessons")
public class TutorEntity {
    @Id
    @Column(name = "EMAIL_ADDRESS", length = 50, unique = true, nullable = false, updatable = false)
    private String emailAddress;

    @Column(name = "ALIAS", length = 20, unique = true, nullable = false, updatable = false)
    private String alias;

    @Column(name = "FIRST_NAME", length = 15, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "PHONE_NUMBER", length = 9)
    private String phoneNumber;

    @OneToMany(mappedBy = "tutorEntity")
    private Set<IndividualLessonEntity> individualLessons;
}
