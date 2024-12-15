package Q2;

import java.util.Scanner;

class MyQueue{
	int queueSize;
	int arr[];
	int q_front;
	int q_rear;
	public MyQueue(int queueSize) {

		this.queueSize = queueSize;
		arr = new int[queueSize];
		q_front =0;
		q_rear = -1;

	}


	void enqueue(int val) {
		q_rear =q_rear+1;
		arr[q_rear]= val;
	}


	public int dequeue() {
		int q_element;
		q_element =arr[q_front];
		q_front =q_front + 1;
		return q_element;

	}

	public boolean isEmpty() {
		if(q_rear == -1 || q_front>q_rear)
			return true;
		else
			return false;
	}
	public boolean isFull() {
		if(q_rear == queueSize-1) return true;
		else return false;
	}

	public int size() {
		return q_rear+1;
	}

	public void displayAllElements() {
		if(isEmpty()) {
			System.out.println("Queue is empty! no elements to display!");
		}else {
			System.out.println("Element in the queue are:  ");
			for(int i=q_front;i<=q_rear;i++)System.out.print(arr[i] +" ");
			System.out.print("");
		}
	}
}

public class QueueArray {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyQueue mq= new MyQueue(5);
		int val;
		int choice;

		do {
			System.out.print("\n1.Insert(enqueue)\n");
			System.out.print("2.Delete (dequeue)\n");
			System.out.print("3.Display\n");
			System.out.print("4.Exit \n");
			System.out.print("Enter your choice  : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:if(mq.isFull()== false)
				{
					System.out.print("\nEnter value to be enqueued (inserted) : ");
					val = sc.nextInt();
					mq.enqueue(val);
				}else 
					System.out.print("\nQueue is full, can not enqueue element!");
			break;

			case 2: if(mq.isEmpty()==false) {
					val=mq.dequeue();
					System.out.print("\nQueue is empty,c an not dequeue element !\n");
					}
				else {
					System.out.print("\nQueue is empty, can not dequeue element!\n");
					}
			break;

			case 3:mq.displayAllElements();
			break;
			
			case 4:System.out.println("Exiting the program. ");
			break;

			default: System.out.print("\nWrong choice! \n");
			}

		}while(choice!=4);
		sc.close();
	}

}
