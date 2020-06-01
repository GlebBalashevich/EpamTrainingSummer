package com.balashevich.day1.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Using to interact with the user in order to solve a task
 * with methods writeMessage(), writeMap(), readString(), readDouble()
 * program asking user to enter needed parameters in the console
 * and write result of the program.
 * in method writeMap() using TreeMap object, b'cos it have sorted structure
 * For reading data from console using BufferedReader
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 * @see BufferedReader
 * @see TreeMap
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
     * Writing in the console TreeMap like a table for visualization of calculation results
     */
    public void writeMap(TreeMap<Double, Double> map) {
        writeMessage("_________________");
        writeMessage("|  X  | | tg(x) |");

        for (Map.Entry<Double, Double> elem : map.entrySet()) {
            writeMessage(String.format("| %.1f | | %.3f |", elem.getKey(), elem.getValue()));
        }

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
     * Reading from the console Double value entered by user.
     * it still read data from console until number value became valid
     */
    public double readDouble() {
        double number = 0;

        while (true) {
            try {
                number = Double.parseDouble(readString());
                break;
            } catch (NumberFormatException e) {
                writeMessage("An exception occurred while trying to enter Number. Try again");
            }
        }

        return number;
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
