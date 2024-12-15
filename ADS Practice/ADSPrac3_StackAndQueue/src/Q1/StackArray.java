package Q1;

import java.util.Scanner;

class MyStack{
	private int maxSize;
	private int top;
	private int[] stackArray;
	
	public MyStack(int maxSize) {

		this.maxSize = maxSize;
		stackArray = new int[maxSize];
		top =-1;

	}

	//push operation
	public void push(int value) {
		if(isFull()) {System.out.println("stack is full ! cannot push element! ");}
		else {
			stackArray[++top]= value;
		}
	}

	//pop operation
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty! can not pop element!");
			return -1;
		}
		else {
			return stackArray[top--];
		}
	}

	//peek operation
	public int peek() {
		if(isEmpty()) {
			System.out.println("stack is empty!");
			return-1;
		}else {
			return stackArray[top];
		}
	}

	//check if the stack is full
	public boolean isFull() {
		return ( top == maxSize -1);
	}

	//check if the stack is empty
	public boolean isEmpty() {
		return top == -1;
	}

	void displayAll() {
		if(top == -1) {
			System.out.println("\nStack is emptpy! No element to display!\n");
		}else {
			System.out.println("Elements in the stack are:    ");
			for(int i=top;i>=0;i--)
				System.out.println(stackArray[i]+" ");
			System.out.println(" ");
		}
	}

}

public class StackArray {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);

		MyStack st = new MyStack(5);
		int val;
		int choice;

		do {
			System.out.print("\n1.Push\n");
			System.out.print("\n2.Pop\n");
			System.out.print("\n3.Peek\n");
			System.out.print("\n4.Display\n");
			System.out.print("\n5.Exit\n");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:System.out.println("Enter value to be pushed : ");
					val = sc.nextInt();
					st.push(val);
					break;
					
			case 2:	val=st.pop();
					System.out.println("popped element is:  "+val);
					break;
					
			case 3:System.out.println("Peeked element is: "+st.peek());
					break;
						
			case 4:st.displayAll();
					break;
					
			case 5:System.out.println("Exiting the program. ");
					break;
					
			default : System.out.println("Wrong choice! ");
			
			}
			
		}while(choice!=5);
		sc.close();
	}
}


//conclusion:
//This,java program effectively demostrates the implementation of a stack data structure using an array. 
//it showcases fundamental operations like push, pop,and peek, providing a clear undestanding ofs stack behavior. 
//By using arrays, the program highlithing the simplicity ans efficiency of stack operations in a fixed-size content. 
//This approach serves as a foundamental concept for learning about more complex data structures.