package com.company.oop;

import java.io.*;

public class ReadTextFileExample {
    // Method is declared with throws because IOException is not handled in the program
    public static void main(String[] args) throws IOException {
        // Use try-with-resources so that stream is handled correctly
        try (FileWriter writer = new FileWriter("file.txt")) {
            writer.write("Hello world!\n");
            writer.write("I am writing to a text file :)\n");
            writer.flush();
        }

        // try-with-resources can manage multiple streams
        try (
                FileReader reader = new FileReader("file.txt");
                // BufferedReader allows reading line by line
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                System.out.println(line);
            }
        }
    }
}
