package homework7;

import java.util.ArrayList;

public class DayOfTheWeek {
    private ArrayList<String> daysList;

    public DayOfTheWeek() {
        daysList = new ArrayList<>();
        daysList.add("Sunday");
        daysList.add("Monday");
        daysList.add("Tuesday");
        daysList.add("Wednesday");
        daysList.add("Thursday");
        daysList.add("Friday");
        daysList.add("Saturday");
    }

    public String getDay(Integer dayNumber) {
        if (dayNumber == null) {
            throw new NullPointerException("Input cannot be null");
        } else if (dayNumber < 1 || dayNumber > 7) {
            return "The number should be between 1 and 7 (inclusive)";
        } else {
            return daysList.get(dayNumber - 1);
        }
    }
    
}