import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Event_Planner {

    private static final String PATH = "..\\Event-Planner-Weather-App\\data_files\\";
    private List<Event> event_list = new ArrayList<>();
    private PrintWriter pw = null;

    public void read_data(String input_filename) {
        File input_file = new File(PATH + input_filename + ".txt");

        String[] tokens;
        try (Scanner sc = new Scanner(input_file)) {
            if (input_file.length() == 0) {
                System.out.println(input_filename + " is empty.");
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                tokens = line.split(",");

                if ("event_planner_data".equals(input_filename)) {
                    event_list.add(new Event(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + input_file + " was not found.");
        }
    }

    public void backup_data(String input_filename) throws FileNotFoundException {
        File txt = new File(PATH + input_filename + ".txt");
        File bu1 = new File(PATH + input_filename + ".bu.1");
        File bu2 = new File(PATH + input_filename + ".bu.2");
        File bu3 = new File(PATH + input_filename + ".bu.3");

        Scanner sc_backup = null;

        if (txt.exists()) {
            sc_backup = new Scanner(txt);
            File txt2 = new File(PATH + input_filename + "2.txt");
            pw = new PrintWriter(txt2);
            while (sc_backup.hasNextLine()) {
                String curr = sc_backup.nextLine();
                pw.println(curr);
            }

            if (bu1.exists()) {
                if (bu2.exists()) {
                    if (bu3.exists()) {
                        bu3.delete();
                        pw.close();
                        if (bu2.renameTo(new File(PATH + input_filename + ".bu.3"))) {
                            //System.out.println("renamed");
                        }
                        txt2.renameTo(new File(PATH + input_filename + ".bu.1"));
                        //txt2.delete();
                    } else {
                        pw.close();
                        if (bu2.renameTo(new File(PATH + input_filename + ".bu.3"))) {
                            //System.out.println("renamed");
                        }
                    }
                    //bu2.delete();
                    pw.close();
                    if (bu1.renameTo(new File(PATH + input_filename + ".bu.2"))) {
                        //System.out.println("renamed");
                    }
                    txt2.renameTo(new File(PATH + input_filename + ".bu.1"));
                    //txt2.delete();
                } else {
                    pw.close();
                    if (bu1.renameTo(new File(PATH + input_filename + ".bu.2"))) {
                        //System.out.println("renamed");
                    }
                }
                //txt2.delete();
                pw.close();
                if (txt2.renameTo(new File(PATH + input_filename + ".bu.1"))) {
                    //System.out.println("renamed");
                }
                //txt2.delete();
            } else {
                pw.close();
                if (txt2.renameTo(new File(PATH + input_filename + ".bu.1"))) {
                    //System.out.println("renamed");
                }
                txt2.delete();
            }
        }
        pw.close();
        sc_backup.close();

    }

    public void display() {
        System.out.println("----------------- Events ------------------");
        for (Event event : event_list) {
            System.out.print(event.toString());
        }
    }

    public void add_event(Scanner sc, String input_filename) throws IOException {
        System.out.println("-------------------------------------------");
        System.out.print("Enter Title of the Event: ");
        String title = sc.nextLine();
        System.out.println("Enter Description: ");
        String description = sc.nextLine();
        System.out.println("Enter Month: ");
        int month = sc.nextInt();
        System.out.println("Enter Date: ");
        int date = sc.nextInt();
        System.out.println("Enter Year: ");
        int year = sc.nextInt();

        Event temp_event = new Event(title, description, month, date, year);
        event_list.add(temp_event);
        System.out.println("Event successfully added to the planner.");

        FileWriter fileWriter = new FileWriter(PATH + input_filename + ".txt", true);
        pw = new PrintWriter(fileWriter);
        pw.println(temp_event.get_title() + "," + temp_event.get_description() + "," +
                temp_event.get_month() + "," + temp_event.get_date() + "," + temp_event.get_year());
        pw.close();

    }

    public void remove_event() {

    }

    public boolean menu() throws InterruptedException, IOException {
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
            case "2":
                add_event(sc, "event_planner_data");
                break;
            case "3":
                remove_event();
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
