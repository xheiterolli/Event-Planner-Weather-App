public class Stack{
    Node top;

    public static class Node{
        int data;
        Node next;

        //constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // checks if stack is empty
    public boolean isEmpty(){
        return top == null;
    }

    // read the top value of the stack
    public int peek(){
        if(isEmpty()){
            System.out.println("The list is empty.");
        }
        return top.data;
    }

    // push value into the stack
    public void push(int data){
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;
    }

    // remove the top value of the stack
    public int pop(){
        if(isEmpty()){
            System.out.println("The list is empty.");
        }
        int remove = top.data;
        top = top.next;
        return remove;
    }

    // print out the stack
    public void displayStack(){
        Node current = top;

        System.out.print("Stack list : ");

        while(current != null){
            System.out.print(current.data + " ");

            current = current.next;
        }
    }
}