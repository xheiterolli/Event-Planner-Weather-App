import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Weather_Application {

    private final Linked_List city_list = new Linked_List();

    public boolean menu() throws InterruptedException, IOException {
        System.out.println("-------------------------------------------");
        System.out.println("Please pick one the options below:");
        System.out.println("1. Display List of Cities");
        System.out.println("2. Find City Weather");
        System.out.println("3. Add City");
        System.out.println("4. Remove City");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        boolean canContinue = true;

        switch (choice) {
            case "1":
                Linked_List.printList(city_list);
                break;
            case "2":
                System.out.print("Type the name of the city: ");
                String find_input = sc.nextLine();
                city_list.contains(city_list, find_input);
                break;
            case "3":
                System.out.print("Type the name of the city: ");
                String add_input = sc.nextLine();
                city_list.insert(city_list, add_input);
                break;
            case "4":
                System.out.print("Type the name of the city: ");
                String remove_input = sc.nextLine();
                city_list.remove(city_list, remove_input);
                break;
            case "0":
                canContinue = false;
                System.out.print("Closing Weather Application");
                TimeUnit.SECONDS.sleep(1);
                System.out.print("\rThank you for using the Weather Application.");
            default:
                System.out.print("");
        }
        return canContinue;
    }
}
