package com.balashevich.day1.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Using to interact with the user in order to solve a task
 * with methods writeMessage(), readString(), readInt()
 * program asking user to enter needed parameters in the console
 * and write result of the program.
 * For reading data from console using BufferedReader
 * For writing number using BigInteger
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
     * Reading from the console Number of Day seconds entered by user.
     * it still read data from console until number value became valid
     */
    public int readInt() {
        int second = 0;
        writeMessage("Enter the Second of day");

        while (true) {
            try {
                second = Integer.parseInt(readString());
                if (second > 0 && second <= 86400) {
                    break;
                } else {
                    writeMessage("Invalid Second value. Try again");
                }
            } catch (NumberFormatException e) {
                writeMessage("An exception occurred while trying to enter Number. Try again");
            }
        }

        return second;
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
