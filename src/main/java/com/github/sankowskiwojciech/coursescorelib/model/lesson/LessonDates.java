package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class LessonDates {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}
