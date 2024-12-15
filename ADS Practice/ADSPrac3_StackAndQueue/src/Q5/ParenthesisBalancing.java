package Q5;

import java.util.Scanner;

class MyStack{
	int maxSize;
	int top;
	char[] stackArray;
	public MyStack(int maxSize) {
		
		this.maxSize = maxSize;
		stackArray = new char[maxSize];
		top=-1;
		
	}
	
	//push operation
	public void push(char value) {
		if(isFull()) {
			System.out.println("stack is full! can not push element!");
		}else {
			stackArray[++top] = value;
		}
	}
	
	//pop operation
	public char pop() {
		if(isEmpty()) {
			System.out.println("stack is empty! cannot pop element! ");
			return 'E';
		}else {
			return stackArray[top--];
		}
	}
	
	///check if the stack is full
	public boolean isFull() {
		return (top == maxSize -1);
	}
	//check if the stack is empty
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void displayAll() {
		if(top == -1) {
			System.out.println("stack is empty! no elements to display!");
		}else {
			System.out.println("elements in the stack are: ");
			for(int i=top;i>=0;i--)
				System.out.println(stackArray[i]+" ");
			System.out.println("");
		}
	}
}
public class ParenthesisBalancing {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	MyStack st =new MyStack(10);
	System.out.println("Please enter postfix expression: ");
	String exp = sc.nextLine();
	int isValid=1;
	char c;
	//scan all the characters one by one
	for(int i=0;i<exp.length();i++) {
		c = exp.charAt(i);
		char stChar;
		if(c=='{' || c=='[' || c=='(') {
			st.push(c);
		}else {
			if(st.isEmpty()) {
				isValid =0;
				break;
			}else {
				stChar = st.pop();
				if((stChar != '(' && c == ')') || (stChar != '{' && c=='}') || (stChar != '[' && c==']' )) {
					isValid = 0;
					break;
				}
			}
		}
	}
	
	if(isValid==1 && st.isEmpty())
		System.out.println("Parenthesis are BALANCED! ");//{[()]}
	else
		System.out.println("Parenthesis are NOT BALANCED! ");//[]{}()}
	sc.close();
}
}
