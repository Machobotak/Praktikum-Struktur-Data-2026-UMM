package task2;

public class Queue {
    private Node front, rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String name) {
        Node newNode =  new Node(name);
        if(rear == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public String dequeue() {
        if(isEmpty()){
            return null;
        }
        String name = front.name;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return name;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue kosong");
            return;
        }

        Node temp = front;
        int i = 1;
        while(temp != null){
            System.out.println(i+ ". "+temp.name);
            temp = temp.next;
            i++;
        }
    }
}
