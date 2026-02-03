package com.github.nicolasholanda.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeBasics {

    static void execute() {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalDate specificDate = LocalDate.of(2026, Month.FEBRUARY, 2);
        System.out.println("Specific date: " + specificDate);

        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());
        System.out.println("Day of week: " + today.getDayOfWeek());

        LocalTime now = LocalTime.now();
        System.out.println("Now: " + now);

        LocalTime specificTime = LocalTime.of(14, 30, 45);
        System.out.println("Specific time: " + specificTime);

        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Second: " + now.getSecond());

        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("Now: " + nowDateTime);

        LocalDateTime specific = LocalDateTime.of(2026, 2, 2, 1, 30);
        System.out.println("Specific: " + specific);

        System.out.println("Date: " + nowDateTime.toLocalDate());
        System.out.println("Time: " + nowDateTime.toLocalTime());
    }
}


