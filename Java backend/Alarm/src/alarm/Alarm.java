/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import java.util.Scanner;

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
                while (alarmHour < 0 || alarmHour > 12) {
                    System.out.println("Hours: (1-12)");
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
                    alarmHour += 11;
                    System.out.println(alarmHour + ":" + alarmMinute);
                }
            }
            while (alarmOn) {

            }
        }

    }

    public void setAlarm() {

    }

    public void getAlarm() {

    }

    public void ring() {

    }

}
