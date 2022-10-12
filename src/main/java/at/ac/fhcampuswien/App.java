package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int daysInMonth, int firstDay) {
        int offsetDays = firstDay - 1;

        printCalendarOffset(offsetDays);
        printCalendarDays(daysInMonth, offsetDays);
    }

    private static void printCalendarOffset(int offsetDays) {
        for (int offset = 0; offset < offsetDays; offset++) {
            System.out.print("   ");
        }
    }

    private static void printCalendarDays(int daysInMonth, int offsetDays) {
        for (int currentDay = 1; currentDay <= daysInMonth; currentDay++) {
            if (currentDay < 10) System.out.print(" ");

            System.out.print(currentDay);
            System.out.print(" ");

            if ((currentDay + offsetDays) % 7 == 0 || (currentDay == daysInMonth)) {
                System.out.println();
            }
        }
    }

    public static long[] lcg(long seed) {
        long[] randomNumbers = new long[10];

        for (int i = 0; i < 10; i ++) {
            seed = generateRandomNumber(seed);
            randomNumbers[i] = seed;
        }

        return randomNumbers;
    }

    private static long generateRandomNumber(long seed) {
        long factor = 1103515245L;
        short increment = 12345;
        long modul = 2147483648L;

        return (factor * seed + increment) % modul;
    }


    public static void main(String[] args) {

        System.out.println("Assignment 1:");
        oneMonthCalendar(31, 3);
        System.out.println("--------------------------------");

        System.out.println("Assignment 2:");
        long[] randoms = lcg(11);
        for (long i = 1; i < randoms.length; i++) {
            System.out.printf("Number %d: %d", i,randoms[(int) i]);
            System.out.println();
        }
        System.out.println("--------------------------------");

    }
}