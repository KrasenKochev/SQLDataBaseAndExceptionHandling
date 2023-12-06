package com.company.oop;

import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to divide:");
        int number = scanner.nextInt();

        System.out.println("Enter a divisor:");
        int divisor = scanner.nextInt();

        try {
            int result = number / divisor;

            System.out.printf(
                    "The result from the division of %d by %d is: %d%n",
                    number,
                    divisor,
                    result);
        } catch (ArithmeticException e) { // We can catch parent class as well (Exception or RuntimeException)
            System.out.println("Dividing by 0 is not allowed!");
        }
    }
}
