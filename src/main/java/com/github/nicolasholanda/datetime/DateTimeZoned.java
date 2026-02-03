package com.github.nicolasholanda.datetime;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Instant;
import java.time.LocalDateTime;

public class DateTimeZoned {

    static void execute() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Current zoned time: " + now);

        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Tokyo time: " + tokyo);

        ZonedDateTime newYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York time: " + newYork);

        ZonedDateTime london = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.println("London time: " + london);

        LocalDateTime localDateTime = LocalDateTime.of(2026, 2, 3, 15, 30);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Converted to zoned: " + zonedDateTime);

        Instant instant = Instant.now();
        System.out.println("Instant (UTC): " + instant);

        ZonedDateTime fromInstant = instant.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println("Instant to Tokyo: " + fromInstant);

        Instant toInstant = zonedDateTime.toInstant();
        System.out.println("Zoned to instant: " + toInstant);
    }
}

