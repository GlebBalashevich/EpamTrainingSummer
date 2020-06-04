package com.balashevich.oopstyle.parser;

public class VariableParser {
    public int parseInt(String data) {
        return Integer.parseInt(data);
    }

    public int[] parseIntArray(String data) {
        String[] dataValues = data.split(",");
        int[] numbers = new int[dataValues.length];

        for (int i = 0; i < dataValues.length; i++) {
            numbers[i] = parseInt(dataValues[i].trim());
        }

        return numbers;
    }

    public long parseLong(String data) {
        return Long.parseLong(data);
    }

    public double parseDouble(String data) {
        return Double.parseDouble(data);
    }
}
