package com.example.weeklytemperatures;

import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {
    public static void main(String[] args) {
        ArrayList<String> daysOfWeek = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Populate days of the week
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        // Prompt the user for temperatures
        for (String day : daysOfWeek) {
            System.out.print("Enter the average temperature for " + day + ": ");
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        // Prompt the user to enter a day or 'week'
        while (true) {
            System.out.print("Enter a day of the week to display the temperature or 'week' to display all temperatures: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("week")) {
                displayWeeklyTemperatures(daysOfWeek, temperatures);
                break;
            } else {
                displayDailyTemperature(daysOfWeek, temperatures, input);
            }
        }

        scanner.close();
    }

    private static void displayDailyTemperature(ArrayList<String> days, ArrayList<Double> temps, String day) {
        int index = days.indexOf(day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase());
        if (index != -1) {
            System.out.println(day + ": " + temps.get(index) + "°C");
        } else {
            System.out.println("Invalid day. Please try again.");
        }
    }

    private static void displayWeeklyTemperatures(ArrayList<String> days, ArrayList<Double> temps) {
        double total = 0;
        System.out.println("Weekly temperatures:");
        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i) + ": " + temps.get(i) + "°C");
            total += temps.get(i);
        }
        double average = total / days.size();
        System.out.println("Weekly average temperature: " + average + "°C");
    }
}
