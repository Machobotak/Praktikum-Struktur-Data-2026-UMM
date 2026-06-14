package task2;

public class Stack {
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }
    public void push(String name) {
        Node newNode = new Node(name);
        newNode.next = top;
        top = newNode;
    }
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String name = top.name;
        top = top.next;
        return name;
    }
}
