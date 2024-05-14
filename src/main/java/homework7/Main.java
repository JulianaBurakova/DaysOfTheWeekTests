package homework7;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        int dayNumber = 5;
        String dayName = dayOfTheWeek.getDay(dayNumber);
        System.out.println("Day " + dayNumber + ": " + dayName);
    }
}