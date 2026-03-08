import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueCodelab {
    static void main() {
        Queue<String> serviceQueue = new LinkedList<>();
        serviceQueue.add("Andi");
        serviceQueue.add("Titan");
        serviceQueue.add("Rapi");

        System.out.println("Initial Service Queue : \n" + serviceQueue);
        String servedPassenger = serviceQueue.poll();
        System.out.println("Served Passenger : " + servedPassenger);
        System.out.println("Queue after serving :\n" + serviceQueue);

        String nextPassenger = serviceQueue.peek();
        System.out.println("Next Passenger : " + nextPassenger+"\n");


        Stack<String> transactionHistory = new Stack<>();
        transactionHistory.push("Transaction-1");
        transactionHistory.push("Transaction-2");
        transactionHistory.push("Transaction-3");
        System.out.println("Trasaction History : \n" + transactionHistory);

        String lastTransaction = transactionHistory.pop();
        System.out.println("Undo Last Transaction : " + lastTransaction);

        System.out.println("Trasaction History After undo: \n" + transactionHistory);

        String topTransaction = transactionHistory.peek();
        System.out.println("Current Top Transaction : " + topTransaction+"\n");

        if(transactionHistory.isEmpty()){
            System.out.println("No Transaction History");
        }else {
            System.out.println("Transaction History is not empty. Size : " + transactionHistory.size());
        }
    }
}
