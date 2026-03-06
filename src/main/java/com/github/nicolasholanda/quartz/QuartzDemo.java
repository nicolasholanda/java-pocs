package com.github.nicolasholanda.quartz;

public class QuartzDemo {

    static void main() {
        System.out.println("--- Quartz basics ---");
        QuartzBasics.execute();

        System.out.println("\n--- Quartz cron ---");
        QuartzCron.execute();
    }
}
