package Client;

import java.io.Serializable;
import java.util.ArrayList;
import static java.lang.Character.toTitleCase;

public class LinkedList {

    class Node{
        public int data;
        public Node next;
        public Node(int d) {
            data = d;
            next = null;
        }
    }
    private Node head;
    private Node tail;
    private int temp;
    private int tempHigh;
    private int tempLow;
    private int humidity;
    private int windSpeed;
    private int cloudCover;
    private String city;
    private String country;
    private String description;
    private ArrayList<Node> queue ;
//    private Node current;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.temp = 0;
        this.tempHigh = 0;
        this.tempLow = 0;
        this.humidity = 0;
        this.windSpeed = 0;
        this.cloudCover = 0;
        this.city = "City";
        this.country = "US";
        this.description = "Bright and Clear";
        this.queue = new ArrayList<>();
    }

    // adds node 
    void append(int data) {
        Node new_node = new Node(data);
        if (this.head == null) {
            head = new Node(data);
            return;
        }
        new_node.next = null;

        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = new_node;
        return;
    }

   // adds info to the list
    void addToList(){
        Node current = head;
        int weatherInfo =Integer.parseInt ("");
        while (current == null) {
            weatherInfo += current.data;
            current = current.next;
        }
        append(Integer.parseInt(String.valueOf(weatherInfo)));
    }

    // searches for cities in the queue
    public Serializable find(int key) {
        System.out.println("\n");
        for (int x = 0; x < queue.size(); x++) {
                return x;
            }
        return ("" + key + " was not in the list. Please check if the city is in the list.");
    }
    void printList(){
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(i);
        }
    }
}