public class Queue {
    Node head;
    Node tail;

    public static class Node{
        int data;
        Node next;

        // constructor
        public Node(int data){
            this.data= data;
            this.next = null;
        }
    }

    // checks if queue is empty
    public boolean is_empty(){
        return head == null;
    }

    // checks the head value of the head
    public int look(){
        if(is_empty()){
            System.out.println("The queue is empty.");
        }
        return head.data;
    }

    // pushes new values into the queue
    public void enqueue(int data){
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

        System.out.print("Queue list : ");

        while(current != null){
            System.out.print(current.data + " ");

            current = current.next;
        }
    }

    // removes the first value from the queue
    public int dequeue(){
        if(is_empty()){
            System.out.println("The queue is empty.");
        }
        int result = head.data;
        head = head.next;
        return result;
    }

    public static void main(String [] args){
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(159);
        queue.enqueue(23);
        queue.enqueue(121);
        queue.enqueue(77);
        queue.enqueue(8);
        queue.enqueue(19);
        queue.enqueue(6);

        queue.display_queue();
        System.out.print("\n" + "The queue is empty : " + queue.is_empty());
        System.out.print("\n" + "The top data : " + queue.look());
        System.out.print("\n" + "The remove data : " + queue.dequeue());
        System.out.println();
        queue.display_queue();
    }
}