package Q4;

import java.util.Scanner;

class MyStack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push element!");
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop element!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No elements to display!");
        } else {
            System.out.println("Elements in the stack are: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}

public class PostfixEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dynamically set the stack size
        System.out.println("Enter the maximum size of the stack: ");
        int stackSize = sc.nextInt();
        MyStack st = new MyStack(stackSize);

        // Input the postfix expression
        System.out.println("Please enter a postfix expression: ");
        sc.nextLine(); // Clear the newline character
        String exp = sc.nextLine();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the character is a digit, push it to the stack
            if (Character.isDigit(c)) {
                st.push(c - '0');
            } else {
                // If the character is an operator, pop two values and perform the operation
                int val1 = st.pop();
                int val2 = st.pop();

                switch (c) {
                    case '+':
                        st.push(val2 + val1);
                        break;
                    case '-':
                        st.push(val2 - val1);
                        break;
                    case '/':
                        st.push(val2 / val1);
                        break;
                    case '*':
                        st.push(val2 * val1);
                        break;
                    case '^':
                        st.push((int) Math.pow(val2, val1));
                        break;
                    default:
                        System.out.println("Invalid operator found: " + c);
                        return;
                }
            }
        }

        // The final result will be the last value in the stack
        System.out.println("The final result is: " + st.pop());

        sc.close();
    }
}
