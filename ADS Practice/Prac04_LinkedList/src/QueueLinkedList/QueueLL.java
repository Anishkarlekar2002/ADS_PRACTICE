package QueueLinkedList;


//Q.6 Write a java program to demonstrate the working of Queue using Linked List.
//Java program to implement queue data structure using linked list

class Node {
 int data;
 Node next;

 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

class Queue {
 Node front, rear;

 Queue() {
     front = rear = null;
 }

 boolean isEmpty() {
     return front == null && rear == null;
 }

 // Function to add an element in the queue
 void enqueue(int d) {
     // create a new linked list node
     Node new_node = new Node(d);
     if (rear == null) {
         front = rear = new_node;
         return;
     }
     rear.next = new_node;
     rear = new_node;
 }

 // function to remove element from the queue
 void dequeue() {
     if (isEmpty()) {
         System.out.println("Queue Underflow!");
         return;
     }
     Node temp = front;
     front = front.next;
     if (front == null) {
         rear = null;
     }
 }

 int getFront() {
     if (isEmpty()) {
         System.out.println("Queue Underflow!");
         return Integer.MIN_VALUE;
     } else {
         return front.data;
     }
 }

 int getRear() {
     if (isEmpty()) {
         System.out.println("Queue Underflow!");
         return Integer.MIN_VALUE;
     } else {
         return rear.data;
     }
 }

 public void displayQueue() {
     Node current = front;
     if (front == null) {
         System.out.println("Queue is empty!");
         return;
     }
     System.out.println("The data in Queue: ");
     while (current != null) {
         System.out.print(current.data + " -> ");
         current = current.next;
     }
     System.out.print("null\n");
 }
}

public class QueueLL {
 public static void main(String[] args) {
     Queue q = new Queue();
     q.enqueue(10);
     q.enqueue(20);
     q.enqueue(30);
     q.enqueue(40);
     q.enqueue(50);
     q.displayQueue();
     System.out.println("\nFront element is " + q.getFront());
     System.out.println("Rear element is " + q.getRear());
     System.out.println("\nRemoving the two element...");
     q.dequeue();
     q.dequeue();
     System.out.println();
     q.displayQueue();
     System.out.println("\nFront element is " + q.getFront());
     System.out.println("Rear element is " + q.getRear());
 }
}