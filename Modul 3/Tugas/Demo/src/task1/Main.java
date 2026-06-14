package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan ekspresi infix: ");
        String infix = input.nextLine();

        String postfix = ExpressionProcessor.infixToPostfix(infix);
        double result = ExpressionProcessor.evaluatePostfix(postfix);

        System.out.println("Infix   : " + infix);
        System.out.println("Postfix : " + postfix);
        System.out.println("Result  : " + result);

        input.close();
    }
}