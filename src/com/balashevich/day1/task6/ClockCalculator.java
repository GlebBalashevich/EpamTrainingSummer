package com.balashevich.day1.task6;

/**
 * Using the calculateClock method decomposes the transmitted
 * number of seconds of the day into full hours minutes seconds
 *
 * @author Gleb Balashevich
 * @version 1.00 30 May 2020
 */

public class ClockCalculator {
    private final int HOUR_SECONDS = 3600;
    private final int MINUTE_SECONDS = 60;

    private int dayTimeSeconds;
    private int dayFullHours;
    private int dayFullMinutes;
    private int dayFullSeconds;

    public ClockCalculator(int dayTimeSeconds) {
        this.dayTimeSeconds = dayTimeSeconds;
    }

    public int getDayTimeSeconds() {
        return dayTimeSeconds;
    }

    public void setDayTimeSeconds(int dayTimeSeconds) {
        this.dayTimeSeconds = dayTimeSeconds;
    }

    public int getDayFullHours() {
        return dayFullHours;
    }

    public void setDayFullHours(int dayFullHours) {
        this.dayFullHours = dayFullHours;
    }

    public int getDayFullMinutes() {
        return dayFullMinutes;
    }

    public void setDayFullMinutes(int dayFullMinutes) {
        this.dayFullMinutes = dayFullMinutes;
    }

    public int getDayFullSeconds() {
        return dayFullSeconds;
    }

    public void setDayFullSeconds(int dayFullSeconds) {
        this.dayFullSeconds = dayFullSeconds;
    }

    /**
     * divides the total number of seconds in full hours, minutes, seconds
     */
    public void calculateClock() {
        int balanceSeconds = dayTimeSeconds;

        dayFullHours = balanceSeconds / HOUR_SECONDS;
        balanceSeconds = balanceSeconds % HOUR_SECONDS;

        dayFullMinutes = balanceSeconds / MINUTE_SECONDS;

        dayFullSeconds = balanceSeconds % MINUTE_SECONDS;
    }
}
