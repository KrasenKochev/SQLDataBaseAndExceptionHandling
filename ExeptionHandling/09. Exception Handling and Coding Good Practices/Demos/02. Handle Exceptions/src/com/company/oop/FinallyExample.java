package com.company.oop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to divide:");
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid user input! Integer number is expected.");
            return;
        } finally {
            System.out.println("User input done.");
        }

        System.out.println("Enter a divisor:");
        int divisor;
        try {
            divisor = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid user input! Integer number is expected.");
            return;
        } finally {
            System.out.println("User input done.");
        }

        try {
            int result = number / divisor;

            System.out.printf(
                    "The result from the division of %d by %d is: %d%n",
                    number,
                    divisor,
                    result);
        } catch (ArithmeticException e) {
            System.out.println("Invalid user input! Dividing by 0 is not allowed.");
        } finally {
            System.out.println("For another division, run the program again.");
        }
    }
}
