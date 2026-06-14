package task1;

public class DoubleStack {
    private double[] data;
    private int top;

    public DoubleStack(int size){
        data = new double[size];
        top = -1;
    }
    public void push(double value){
        data[++top] = value;
    }
    public double pop(){
        return data[top--];
    }
}
