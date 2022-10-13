package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {

    private static final int UPPERCASE_CHAR_MIN_VALUE = 65;
    private static final int UPPERCASE_CHAR_MAX_VALUE = 90;
    private static final int LOWERCASE_CHAR_MIN_VALUE = 97;
    private static final int LOWERCASE_CHAR_MAX_VALUE = 122;
    private static final int WHITESPACE_CHAR_MIN_VALUE = 28;
    private static final int WHITESPACE_CHAR_MAX_VALUE = 32;

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

    public static void guessingGame(int numberToGuess) {
        Scanner scan = new Scanner(System.in);
        int counter = 1;
        int guess;

        while (true) {
            System.out.printf("Guess number %d: ", counter);
            guess = scan.nextInt();

            if (guess == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (counter == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            } else if (guess > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else {
                System.out.println("The number AI picked is higher than your guess.");
            }
            counter++;
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        return 1 + (int) (Math.random()*100);
    }

    public static boolean swapArrays(int[] firstArray, int[] secondArray) {
        if (firstArray.length != secondArray.length) return false;
        int[] tempArray = new int[firstArray.length];

        for (int i = 0; i < firstArray.length; i++) {
            tempArray[i] = firstArray[i];
            firstArray[i] = secondArray[i];
            secondArray[i] = tempArray[i];
        }
        return true;
    }

    private static void printArrays(int[] firstArr, int[] secondArr) {
        System.out.print("First array: ");
        for (int i : firstArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Second array: ");
        for (int i : secondArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static String camelCase(String sentence) {
        char[] sentenceCharacters = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isNextUppercase = true;

        for (char c : sentenceCharacters) {
            if(!isValidLetter(c) && !isWhitespace(c)){
                continue;
            }
            if (isWhitespace(c)) {
                isNextUppercase = true;
                continue;
            }
            c = Character.toLowerCase(c);

            if (isNextUppercase) {
                sb.append(Character.toUpperCase(c));
                isNextUppercase = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }

    private static boolean isValidLetter(char c) {
        return UPPERCASE_CHAR_MIN_VALUE <= c && c <= UPPERCASE_CHAR_MAX_VALUE
                || LOWERCASE_CHAR_MIN_VALUE <= c && c <= LOWERCASE_CHAR_MAX_VALUE;
    }

    private static boolean isWhitespace(char c) {
        return WHITESPACE_CHAR_MIN_VALUE <= c && c <= WHITESPACE_CHAR_MAX_VALUE;
    }

    public static int checkDigit(int[] code) {
        int cypher;
        int sum = 0;

        for (int i = 0; i < code.length; i ++) {
            int weight = i + 2;
            int product = weight * code[i];
            sum += product;
        }

        int dif = 11 - (sum % 11);

        if (dif == 10) cypher = 0;
        else if (dif == 11) cypher = 5;
        else cypher = dif;

        return cypher;
    }

    public static void main(String[] args) {

        System.out.println("Assignment 1:");
        oneMonthCalendar(31, 3);
        System.out.println("----------------------------------------------------------------");

        System.out.println("Assignment 2:");
        long[] randoms = lcg(11);
        for (long i = 1; i < randoms.length; i++) {
            System.out.printf("Number %d: %d", i,randoms[(int) i]);
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------");

        guessingGame(randomNumberBetweenOneAndHundred());
        System.out.println("Assignment 3:");
        System.out.println("----------------------------------------------------------------");

        System.out.println("Assignment 4:");
        int[] firstArr = {1,2,3,4,5};
        int[] secondArr = {100,99,60,44,2};

        System.out.println("Before swap:");
        printArrays(firstArr, secondArr);

        swapArrays(firstArr, secondArr);

        System.out.println("After swap:");
        printArrays(firstArr, secondArr);
        System.out.println("----------------------------------------------------------------");

        System.out.println("Assignment 5:");
        String sentence = "   nO,  rAdLeR   iS nOt a ReAl bEer!!!111";
        System.out.println(camelCase(sentence));
        System.out.println("----------------------------------------------------------------");

        System.out.println("Assignment 6:");
        int cypher = checkDigit(new int[]{3, 9, 1, 5, 8});
        System.out.println("Cypher is: " + cypher);

    }
}