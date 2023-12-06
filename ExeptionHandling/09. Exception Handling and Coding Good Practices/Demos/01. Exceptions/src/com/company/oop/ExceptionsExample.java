package com.company.oop;

import java.util.Scanner;

public class ExceptionsExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
    }
}
