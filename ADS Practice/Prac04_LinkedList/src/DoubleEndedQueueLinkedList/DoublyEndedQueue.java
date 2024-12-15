package DoubleEndedQueueLinkedList;


//Q.8 Write a java program to demonstrate the working of Double Ended Queue using Linked List.

import java.util.Scanner;

class Node {
 int data;
 Node prev;
 Node next;

 // Function to get a new node
 public Node(int data) {
     this.data = data;
     this.prev = null;
     this.next = null;
 }
}

public class DoublyEndedQueue {
 Node front;
 Node rear;
 int Size;

 public DoublyEndedQueue() {
     front = rear = null;
     Size = 0;
 }

 public boolean isEmpty() {
     return (front == null);
 }

 // Return the number of elements in the deque
 public int size() {
     return Size;
 }

 // Insert an element at the front end
 public void insertFront(int data) {
     Node newNode = new Node(data);
     if (newNode == null) {
         System.out.println("Overflow!\n");
     } else {
         // If deque is empty
         if (front == null) {
             // Insert node at the front end
             rear = front = newNode;
         } else {
             newNode.next = front;
             front.prev = newNode;
             front = newNode;
         }
         Size++; // To count element
     }
 }

 // Insert an element at the rear end
 public void insertRear(int data) {
     Node newNode = new Node(data);
     if (newNode == null) {
         System.out.println("Overflow!\n");
     } else {
         // If deque is empty
         if (rear == null) {
             // Insert node at the rear end
             front = rear = newNode;
         } else {
             newNode.prev = rear;
             rear.next = newNode;
             rear = newNode;
         }
         Size++;
     }
 }

 // Delete the element from the front end
 public void deleteFront() {
     // If deque is empty then underflow condition
     if (isEmpty()) {
         System.out.println("Underflow - deque is empty");
     } else {
         // Deletes the node from the front end
         Node temp = front;
         front = front.next;
         // If only one element was present
         if (front == null) {
             rear = null;
         } else {
             front.prev = null;
         }
         // Decrements the count of elements by 1
         Size--;
     }
 }

 // Delete the element from the rear end
 void deleteRear() {
     // If deque is empty then 'underflow' condition
     if (isEmpty()) {
         System.out.println("Underflow - deque is empty!\n");
     } else {
         // Deletes the node from the rear end
         Node temp = rear;
         rear = rear.prev;
         // If only one element was present
         if (rear == null) {
             front = null;
         } else {
             rear.next = null;
         }
         // Decrements the count of elements by 1
         Size--;
     }
 }

 // Return the element at the front end
 public int getFront() {
     // If deque is empty, then return -1 value
     if (isEmpty()) {
         return -1;
     }
     return front.data;
 }

 // Return the element at the rear end
 public int getRear() {
     // If deque is empty, then return -1 value
     if (isEmpty()) {
         return -1;
     }
     return rear.data;
 }

 public void display() {
     Node current = front;
     if (front == null) {
         System.out.println("The double ended queue is empty!");
         return;
     }
     System.out.println("The data in double ended queue are: ");
     System.out.print("Null <- ");
     while (current != null) {
         System.out.print(current.data + " <-> ");
         current = current.next;
     }
     System.out.print("Null");
     System.out.println();
 }

 public static void main(String[] args) {
	 DoublyEndedQueue deq = new DoublyEndedQueue();
     Scanner sc = new Scanner(System.in);
     int data, pos;
     int choice;
     do {
         System.out.println("1. Insert Front");
         System.out.println("2. Insert Rear");
         System.out.println("3. Delete Front");
         System.out.println("4. Delete Rear");
         System.out.println("5. Display");
         System.out.println("6. Get Front");
         System.out.println("7. Get Rear");
         System.out.println("8. Exit");
         System.out.println("\nPlease Enter your choice: ");
         choice = sc.nextInt();
         switch (choice) {
             case 1:
                 System.out.println("\n Insert Node at front - Enter data: ");
                 data = sc.nextInt();
                 deq.insertFront(data);
                 deq.display();
                 break;
             case 2:
                 System.out.println("\n Insert Node at rear - Enter data: ");
                 data = sc.nextInt();
                 deq.insertRear(data);
                 deq.display();
                 break;
             case 3:
                 System.out.println("\n Delete node at front: ");
                 deq.deleteFront();
                 deq.display();
                 break;
             case 4:
                 System.out.println("\n Delete node at Rear: ");
                 deq.deleteRear();
                 deq.display();
                 break;
             case 5:
                 System.out.println("\n Display Nodes: ");
                 deq.display();
                 break;
             case 6:
                 System.out.println("\n The front element is : " + deq.getFront());
                 break;
             case 7:
                 System.out.println("\n The rear element is : " + deq.getRear());
                 break;
             case 8:
                 System.out.println("Exiting the program.");
                 break;
             default:
                 System.out.println("You entered wrong choice!");
         }
     } while (choice != 8);
     sc.close();
 }
}