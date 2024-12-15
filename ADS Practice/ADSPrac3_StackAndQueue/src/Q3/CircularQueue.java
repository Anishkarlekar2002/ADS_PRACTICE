package Q3;

import java.util.Scanner;

class MyCircularQueue{
	int queueSize;
	int arr[];
	int q_front;
	int q_rear;

	public MyCircularQueue(int size) {
		queueSize = size;
		arr = new int[queueSize];
		q_front = -1;
		q_rear =-1;
	}


	public void enqueue(int val) {
		//check for empty queue for adding first element
		if(isEmpty()==true) {
			q_rear = 0;
			q_front = 0;
			arr[q_rear]= val;
		}else {
			q_rear = (q_rear + 1)% queueSize;
			arr[q_rear] = val;
		}


	}
	public int dequeue() {
		int q_element;
		if(q_front == q_rear) {
			q_element =arr[q_front];
			q_rear=-1;
			q_front =-1;

		}
		else {
			//more than one element exists
			q_element=arr[q_front];
			q_front=(q_front+1)%queueSize;
		}
		return q_element;
	}

	public boolean isEmpty() {
		if(q_rear == -1) 
			return true;
		else 
			return false;
	}
	public boolean isFull() {
		if((q_rear+1)%queueSize==q_front)
			return true;
		else 
			return false;
	}


	public int size() {
		if(q_rear>q_front)
			return q_rear-q_front+1;
		else
			return queueSize -q_rear-q_front+1;
	}

	public void displayAllElements() {
		if(q_rear == -1) {
			System.out.println("No elements to display !");
			return;
		}
		System.out.println("Elements in the queue are: ");
		for(int i=q_front;i!=q_rear;i=(i+1)%queueSize) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(arr[q_rear]+" ");
		System.out.println("");
	}
}
public class CircularQueue {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		MyCircularQueue q = new MyCircularQueue(5);
		int val;
		int choice;

		do {
			System.out.println("1.Insert (enqueue)");
			System.out.println("2.Delete (dequeue)");
			System.out.println("3.Display ");
			System.out.println("4.Exit");
			System.out.println("Enter your choice: ");
			choice =sc.nextInt()
					;
			switch(choice) {
			case 1: if(q.isFull()==false) {
				System.out.println("Enter value to be enqueued (inserted) :");
				val =sc.nextInt();
				q.enqueue(val);

			}else {
				System.out.println("Queue is full, can not enqueue element!");


			}
			break;

			case 2:if(q.isEmpty()== false) {
				val=q.dequeue();
				System.out.println("Dequeue element is: " +val);
			}else {
				System.out.println("Queue is empty, cannot dequeue element!");
			}break;

			case 3:q.displayAllElements();
			break;
			case 4:System.out.println("Exisiting the program.");
			break;
			default:
				System.out.println("Wrong choice!");
			}
		}while(choice!=4);
	}
}
