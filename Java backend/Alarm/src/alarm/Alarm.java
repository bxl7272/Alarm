package alarm;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Byron
 */
public class Alarm{
    private Clock clock;
    private static int alarmHour = -1;
    private static int alarmMinute = -1;
    private static String amPm = "";
    static LocalDateTime currentTime;
    static LocalDateTime alarmTime;

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
                createDateTime();
                alarmOn = true;
            }
            while (alarmOn) {
                if (LocalDateTime.now().equals(alarmTime)){
                    ring();
                    alarmOn = false;
                }
                        
            }
        }

    }
    public static void createDateTime(){
        currentTime = LocalDateTime.now();
        alarmTime = currentTime.plusHours(alarmHour-currentTime.getHour()).plusMinutes(alarmMinute-currentTime.getMinute());
        System.out.println(alarmTime.toString());
    }
    public static void ring(){
        System.out.println("Ringing");
    }
}
