package Q6;

import java.util.Scanner;

class MyStack {
    int maxSize;
    int top;
    char[] stackArray;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    // Push operation
    public void push(char value) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push element.");
        } else {
            stackArray[++top] = value;
        }
    }

    // Pop operation
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop element!");
            return 'F';
        } else {
            return stackArray[top--];
        }
    }

    // Peek operation
    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return 'F';
        } else {
            return stackArray[top];
        }
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public void displayAll() {
        if (top == -1) {
            System.out.println("Stack is empty! No elements to display.");
        } else {
            System.out.println("Elements in the stack are: ");
            for (int i = top; i >= 0; i--)
                System.out.print(stackArray[i] + " ");
            System.out.println();
        }
    }
}

public class InfixToPostfix {

    // Function to return precedence of operators
    int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    // Function to perform infix to postfix conversion
    void infixToPostfix(String s, MyStack st) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the scanned character is an operand, add it to the output string
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c);
            }
            // If the scanned character is '(', push it to the stack
            else if (c == '(') {
                st.push(c);
            }
            // If the scanned character is ')', pop and add to the output string from the stack until '(' is encountered
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    System.out.println("Invalid expression: mismatched parentheses.");
                    return;
                }
            }
            // If an operator is scanned
            else {
                while (!st.isEmpty() && prec(c) <= prec(st.peek())) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                System.out.println("Invalid expression: mismatched parentheses.");
                return;
            }
            result.append(st.pop());
        }

        System.out.println("Postfix Expression: " + result.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack st = new MyStack(15);

        System.out.println("Please enter an infix expression:");
        String exp = sc.nextLine();

        InfixToPostfix ip = new InfixToPostfix();
        ip.infixToPostfix(exp, st);

        sc.close();
    }
}

//output
//Please enter an infix expression:
//a+b*(c^d-e)^(f+g*h)-i
//Postfix Expression: abcd^e-fgh*+^*+i-