public class Linked_List {
    Node head;
    Node tail;

    static class Node {
        String city_name;
        Node next;
        Node prev;

        Node(String city_name) {
            this.city_name = city_name;
            this.next = null;
            this.prev = null;
        }
    }

    public void insert(Linked_List list, String data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
            list.tail = new_node;
            list.head.prev = null;
        } else {
            list.tail.next = new_node;
            new_node.prev = list.tail;
            list.tail = new_node;
        }
        list.tail.next = null;
    }
  //emarah charles
    public void insertSorted(Linked_List list, String data) {

        Node tnd = list.head;
        Node nnd = new Node(data);

        boolean flag = true;

        while (flag) {
            if (nnd.data < tnd.data) {
                if (tnd.prev == null) {
                    tnd.prev = nnd;
                    list.head = nnd;
                    list.head.next = tnd;
                    list.head.prev = null;
                } else if (tnd.next == null) {
                    nnd.next = list.tail;
                    nnd.prev = list.tail.prev.prev;
                    list.tail.prev.next = nnd;
                    list.tail.prev = nnd;
                } else {
                    tnd.prev.next = nnd;
                    tnd.prev = nnd;
                    nnd.next = tnd;
                    nnd.prev = tnd.prev.prev;
                }
                flag = false;
            } else if (tnd.next == null) {
                tnd.next = nnd;
                list.tail = nnd;
                list.tail.prev = tnd;
                list.tail.next = null;
                flag = false;
            } else {
                tnd = tnd.next;
            }
        }

    }

    public void remove(Linked_List list, String data) {

        Node curr_node = list.head;
        boolean flag = false;

        while (curr_node != null) {
            if (curr_node.city_name.equals(data)) {
                flag = true;
                if (curr_node == list.head) {
                    list.head = list.head.next;
                    list.head.prev = null;
                } else if (curr_node == list.tail) {
                    list.tail = list.tail.prev;
                    list.tail.next = null;
                } else {
                    Node temp = curr_node.prev;
                    temp.next = curr_node.next;
                    temp = curr_node.next;
                    temp.prev = curr_node.prev;
                }
                break;
            } else {
                curr_node = curr_node.next;
            }
        }

        if (!flag) {
            System.out.println("The city could not be found.");
        }
    }

    public void contains(Linked_List list, String data) {
        boolean flag = true;

        if (list.head == null) {
            System.out.print("The list is empty.");
            flag = false;
        }

        Node curr_node = list.head;

        while (flag) {
            if (curr_node.city_name.equals(data)) {
                System.out.println("Yes");
                break;
            } else if (curr_node == list.tail) {
                System.out.println("No");
                break;
            }
            curr_node = curr_node.next;
        }
    }

    public static void printList(Linked_List list) {

        boolean flag = true;

        if (list.head == null) {
            System.out.print("The list is empty.");
            flag = false;
        }

        while (flag) {
            Node curr_node = list.head;

            System.out.print("Linked List: ");

            do {
                System.out.print(curr_node.city_name + " ");
                curr_node = curr_node.next;
            } while (curr_node != null);

            flag = false;
        }
        System.out.println();
    }
}
