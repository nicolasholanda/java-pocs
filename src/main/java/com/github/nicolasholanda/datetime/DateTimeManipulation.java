package com.github.nicolasholanda.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DateTimeManipulation {

    static void execute() {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("Next week: " + nextWeek);

        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Last month: " + lastMonth);

        LocalDate futureDate = today.plusDays(10).plusMonths(2).plusYears(1);
        System.out.println("Complex addition: " + futureDate);

        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        Period age = Period.between(birthDate, today);
        System.out.println("Age: " + age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime meeting = now.plusHours(2).plusMinutes(30);
        System.out.println("Meeting time: " + meeting);

        Duration duration = Duration.between(now, meeting);
        System.out.println("Duration until meeting: " + duration.toMinutes() + " minutes");

        long daysBetween = ChronoUnit.DAYS.between(birthDate, today);
        System.out.println("Days since birth: " + daysBetween);
    }
}

