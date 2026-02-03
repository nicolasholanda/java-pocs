package com.github.nicolasholanda.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatting {

    static void execute() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Custom format: " + now.format(formatter1));

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("ISO-like format: " + now.format(formatter2));

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println("Long format: " + now.format(formatter3));

        String dateString = "02/02/2026";
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(dateString, parser);
        System.out.println("Parsed date: " + parsedDate);

        System.out.println("ISO format: " + now.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}

