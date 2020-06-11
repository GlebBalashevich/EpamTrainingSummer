package balashevich.oopstyle.console;

import java.util.Map;

public class TimeConsole {
    public void printDaysInMonth(int days) {
        System.out.printf("%d days in month.%n", days);
    }

    public void printDayClock(Map<String, Integer> dayClock) {
        System.out.printf("Now is %d hours, %d minutes, %d seconds.%n",
                dayClock.get("hours"), dayClock.get("minutes"), dayClock.get("seconds"));
    }
}
