package com.company.oop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchExample {
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
        } catch (InputMismatchException e) {
            System.out.println("Invalid user input! Integer number is expected.");
        } catch (ArithmeticException e) {
            System.out.println("Invalid user input! Dividing by 0 is not allowed.");
        }
    }
}
