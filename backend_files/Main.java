public class Main {
    public static void main(String[] args) throws InterruptedException {

        Event_Planner event_planner = new Event_Planner();
        event_planner.read_data("calendar_data");
        event_planner.backup_data();

        boolean can_continue = true;
        while (can_continue) {
            can_continue = event_planner.menu();
        }
    }
}