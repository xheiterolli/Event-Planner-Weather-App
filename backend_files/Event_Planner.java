import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Event_Planner {

    private static final String PATH = "..\\Event-Planner-Weather-App\\data_files\\";
    private List<Event> event_list = new ArrayList<>();
    private PrintWriter pw = null;

    public void read_data(String input_filename) {
        File input_file = new File(PATH + input_filename + ".txt");
        Scanner sc = null;
        String[] tokens;

        try {
            sc = new Scanner(input_file);
            if (input_file.length() == 0) {
                System.out.println(input_filename + " is empty.");
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                tokens = line.split(",");

                switch (input_filename) {
                    case "event_planner_data":
                        event_list.add(new Event(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                                Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + input_file + " was not found.");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public void backup_data() {
    }

    public boolean display() {
        System.out.println("----------------- Events ------------------");
        for (int i = 0; i < event_list.size(); i++) {
            System.out.print(event_list.get(i).toString());
        }
        return false;
    }

    public boolean menu() throws InterruptedException {
        System.out.println("-------------------------------------------");
        System.out.println("Please pick one the options below:");
        System.out.println("1. Display Events");
        System.out.println("2. Add Event");
        System.out.println("3. Remove Event");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        boolean canContinue = true;

        switch (choice) {
            case "1":
                display();
                break;
            case "0":
                canContinue = false;
                System.out.print("Closing Event Planner");
                TimeUnit.SECONDS.sleep(1);
                System.out.print("\rThank you for using Event Planner.");
            default:
                System.out.print("");
        }
        return canContinue;
    }
}
