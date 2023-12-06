package com.company.oop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SingleCatchMultipleExceptionsExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a number to divide:");
            int number = scanner.nextInt();

            System.out.println("Enter a divisor:");
            int divisor = scanner.nextInt();

            int result = number / divisor;

            System.out.printf(
                    "The result from the division of %d by %d is: %d%n",
                    number,
                    divisor,
                    result);
        } catch (InputMismatchException | ArithmeticException e) { // We can catch parent class as well (Exception or RuntimeException)
            // The message should be common for both scenarios
            System.out.println("Invalid user input! Two integer numbers are expected, second not 0.");
        }
    }
}
