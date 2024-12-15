package PriorityQueueLinkedList;


//Q.7 Write a java program to demonstrate the working of Priority Queue using Linked List.
//Java program to implement priority queue using linked list

class Node {
 int data;
 int priority; // lower values indicate higher priority
 Node next;

 Node(int d, int p) {
     data = d;
     priority = p;
     next = null;
 }
}

public class PriorityQueueLL {
 Node head;

 public PriorityQueueLL() {
     head = null;
 }

 public void add(int d, int p) {
     Node start = head;
     Node newNode = new Node(d, p);

     // If the list is empty
     if (head == null) {
         head = newNode;
         return;
     }

     // If the new node has higher priority than the head
     if (head.priority > p) {
         newNode.next = head;
         head = newNode;
     } else {
         // Traverse the list to find the correct position for the new node
         while (start.next != null && start.next.priority < p) {
             start = start.next;
         }
         newNode.next = start.next;
         start.next = newNode;
     }
 }

 public Node remove() {
     if (head == null) {
         System.out.println("Priority Queue is empty!");
         return null;
     }
     Node temp = head;
     head = head.next;
     temp = null; // for memory deallocation
     return head;
 }

 int getHeadData() {
     if (head == null) {
         System.out.println("Priority Queue is empty!");
         return -1;
     }
     return head.data;
 }

 public boolean isEmpty() {
     return head == null;
 }

 public void display() {
     Node temp = head;
     System.out.println();
     while (temp != null) {
         System.out.print("Data: " + temp.data + ", priority: " + temp.priority + " --> ");
         temp = temp.next;
     }
     System.out.println("Null");
 }

 public static void main(String[] args) {
	 PriorityQueueLL pq = new PriorityQueueLL();
     pq.add(4, 1); // Adding element 4 with priority 1
     pq.add(5, 2); // Adding element 5 with priority 2
     pq.add(6, 3); // Adding element 6 with priority 3
     pq.add(7, 0); // Adding element 7 with priority 0
     System.out.println("Priority Queue: ");
     pq.display();
     System.out.println("Head node data = " + pq.getHeadData());

     // Remove elements:
     System.out.println("\nRemoving two element: ");
     pq.remove();
     pq.remove();
     System.out.println("Priority Queue after removing two elements : ");
     pq.display();
     System.out.println("\nHead node data after removing Two elements = " + pq.getHeadData());
 }
}