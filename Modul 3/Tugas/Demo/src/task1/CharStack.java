package task1;

public class CharStack {
    private char[] data;
    private int top;

    public CharStack(int size){
        data = new char[size];
        top = -1;
    }

    public void push(char c){
        data[++top] = c;
    }

    public char pop(){
        return data[top--];
    }

    public char peek(){
        return data[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }
}
