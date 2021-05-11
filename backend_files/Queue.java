public class Queue {
    Node head;
    Node tail;

    public static class Node{
        String data;
        Node next;

        // constructor
        public Node(String data){
            this.data= data;
            this.next = null;
        }
    }

    // checks if queue is empty
    public boolean is_empty(){
        return head == null;
    }

    // checks the head value of the head
    public String look(){
        if(is_empty()){
            System.out.println("The queue is empty.");
        }
        return head.data;
    }

    // pushes new values into the queue
    public void enqueue(String data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }

        if(tail != null){
            tail.next = newNode;
        }
        tail = newNode;

    }

    // prints out the queue
    public void display_queue(){
        Node current = head;

        System.out.print("Title List: ");

        while(current != null){
            System.out.print(current.data + ", ");

            if (current == tail) {
                System.out.println("\b\b");
            }

            current = current.next;
        }
    }

    // removes the first value from the queue
    public String dequeue(){
        if(is_empty()){
            System.out.println("The queue is empty.");
        }
        String result = head.data;
        head = head.next;
        return result;
    }
}