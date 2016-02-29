package alarm;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Byron
 */
public class Alarm {

    private static int startTime = 0;
    private static int endTime = 0;
    private static int alarmHour = -1;
    private static int alarmMinute = -1;
    private static String amPm = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean alarmOn = false;

        while (true) {
            while (!alarmOn) {
                System.out.println("Set the alarm");
                while (alarmHour < 0 || alarmHour > 11) {
                    System.out.println("Hours: (0-11)");
                    alarmHour = in.nextInt();
                }
                while (alarmMinute < 0 || alarmMinute > 59) {
                    System.out.println("Minutes: (0-59)");
                    alarmMinute = in.nextInt();
                }
                System.out.println("AM or PM?");
                while (!amPm.equals("am") && !amPm.equals("pm")) {
                    amPm = in.nextLine().toLowerCase();
                }
                if (amPm.equals("pm")) {
                    alarmHour += 12;
                    System.out.println(alarmHour + ":" + alarmMinute);
                }
                convertAlarmTime();
                alarmOn = true;
            }
            while (alarmOn) {
            }
        }

    }
    public static void convertAlarmTime(){
        long millis = System.currentTimeMillis();
        int tempMin = (int)TimeUnit.MILLISECONDS.toMinutes(millis);
    }
}
