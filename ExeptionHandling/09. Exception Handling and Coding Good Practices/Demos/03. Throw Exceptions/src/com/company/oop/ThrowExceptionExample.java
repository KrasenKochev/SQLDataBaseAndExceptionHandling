package com.company.oop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter a number to divide:");
            int number = readInteger();

            System.out.println("Enter a divisor:");
            int divisor = scanner.nextInt();

            int result = divide(number, divisor);

            System.out.printf(
                    "The result from the division of %d by %d is: %d%n",
                    number,
                    divisor,
                    result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Invalid user input! Integer number is expected.");
        }
    }

    private static int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Invalid user input! Dividing by 0 is not allowed.");
        }

        return x / y;
    }
}
