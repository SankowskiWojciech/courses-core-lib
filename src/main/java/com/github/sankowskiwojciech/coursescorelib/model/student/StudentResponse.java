package com.github.sankowskiwojciech.coursescorelib.model.student;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentResponse {
    private final String fullName;
    private final String emailAddress;
}
