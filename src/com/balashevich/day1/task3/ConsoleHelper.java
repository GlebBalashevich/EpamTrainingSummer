package com.balashevich.day1.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Using to interact with the user in order to solve a task
 * with methods writeMessage(), readString(), readSquareArea()
 * program asking user to enter needed parameters in the console
 * and write result of the program.
 * For reading data from console using BufferedReader
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see BufferedReader
 */

public class ConsoleHelper {
    private BufferedReader reader;

    public ConsoleHelper() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Writing in the console text received as a parameter
     */
    public void writeMessage(String text) {
        System.out.println(text);
    }

    /**
     * Reading from the console text entered by user
     */
    public String readString() {
        String text = "";
        try {
            text = reader.readLine();
        } catch (IOException e) {
            writeMessage("An exception occurred while trying to enter String");
        }
        return text;
    }

    /**
     * Reading from the console value of Square Area entered by user.
     * it still read data from console until value of Square Area became valid
     */
    public double readSquareArea() {
        double area = 0;
        writeMessage("Enter the Square Area");

        while (true) {
            try {
                area = Double.parseDouble(readString());
                if (area > 0) {
                    break;
                } else {
                    writeMessage("Invalid Area value. Try again");
                }
            } catch (NumberFormatException e) {
                writeMessage("An exception occurred while trying to enter Number. Try again");
            }
        }

        return area;
    }

    /**
     * Closing reader stream to release resources
     */
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            writeMessage("An exception occurred while trying to close reader stream");
        }
    }
}
