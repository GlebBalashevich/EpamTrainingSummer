package com.balashevich.oopstyle.main;

import com.balashevich.oopstyle.console.TimeConsole;
import com.balashevich.oopstyle.service.TimeService;

public class TimeTasksMain {

    public static void main(String[] args) {
        TimeService timeService = new TimeService();
        TimeConsole timeConsole = new TimeConsole();

        timeConsole.printDaysInMonth(timeService.determineDaysInMonth("2", "2020"));
        timeConsole.printDaysInMonth(timeService.determineDaysInMonth("13", "2020"));
        timeConsole.printDaysInMonth(timeService.determineDaysInMonth("f", "2020"));

        timeConsole.printDayClock(timeService.calculateDayClock("3841"));
        timeConsole.printDayClock(timeService.calculateDayClock("97000"));
        timeConsole.printDayClock(timeService.calculateDayClock("f"));
    }

}
