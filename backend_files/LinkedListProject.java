package Client;

import java.util.ArrayList;

public class LinkedListProject {

    class Node{
        public int data;
        public Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    // Linked List to create the API calls 
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
    private ArrayList queue ;
    private Node current;

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
        this.description = "Clear Skies";
        this.queue = new ArrayList();
    }

    public void append(int data) {
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
}