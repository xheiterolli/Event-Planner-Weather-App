import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        Event_Planner event_planner = new Event_Planner();
        event_planner.read_data("event_planner_data");
        event_planner.backup_data("event_planner_data");

        Weather_Application weather_application = new Weather_Application();

        boolean can_continue = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println("Which program would you like to use?");
        System.out.println("1. Event Planner");
        System.out.println("2. Weather Application");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------");
        String input = sc.nextLine();

        do {
            if (input.equals("1")) {
                can_continue = event_planner.menu();
            } else if (input.equals("2")) {
                can_continue = weather_application.menu();
            } else if (input.equals("0")) {
                can_continue = false;
            } else {
                System.out.println("Please type in a valid choice.");
            }
        } while (can_continue);
    }
}