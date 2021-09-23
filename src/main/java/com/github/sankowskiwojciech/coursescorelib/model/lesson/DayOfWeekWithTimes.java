package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Builder
@Setter
public class DayOfWeekWithTimes {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
