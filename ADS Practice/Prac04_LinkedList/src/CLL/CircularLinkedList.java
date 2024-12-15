package CLL;



//Q.2 Write a java program to demonstrate the working of Circular Linked List.

import java.util.Scanner;

class Node {
 int data;
 Node next;

 public Node(int data) {
     this.data = data;
     this.next = null;
 }
}

public class CircularLinkedList {
 // defining the head and tail of a singly linked list
 Node head;
 Node tail;

 public CircularLinkedList() {
     head = null;
     tail = null;
 }

 public boolean isEmpty() {
     return (head == null);
 }

 // function to add a node to the list
 public void insert(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         newNode.next = newNode;
         head = newNode;
         tail = newNode;
     } else {
         newNode.next = head;
         tail.next = newNode;
         tail = newNode;
     }
 }

 // function to add a node at head
 public void insertAtHead(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         newNode.next = newNode;
         head = newNode;
         tail = newNode;
     } else {
         newNode.next = head;
         head = newNode;
         tail.next = head;
     }
 }

 // function to add a node at tail
 public void insertAtTail(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         newNode.next = newNode;
         head = newNode;
         tail = newNode;
     } else {
         tail.next = newNode;
         tail = newNode;
         tail.next = head;
     }
 }

 // insert node between head and tail
 public void insertAtPosition(int pos, int data) {
     Node newNode = new Node(data);
     int totalNodes = countNodes();
     Node prev = null, current = head;
     // if list is empty
     if (head == null) {
         newNode.next = newNode;
         head = newNode;
         tail = newNode;
     }
     // insert at head
     else if (pos == 1) {
         tail.next = newNode;
         newNode.next = head;
         head = newNode;
     }
     // Insert at position
     else if (pos > 1 && pos <= totalNodes + 1) {
         // insert node at tail
         if (pos == totalNodes + 1) {
             tail.next = newNode;
             tail = newNode;
             tail.next = head; // add
         }
         // Insert node between head and tail
         else {
             for (int i = 1; i < pos; i++) {
                 prev = current;
                 current = current.next;
             }
             newNode.next = current;
             prev.next = newNode;
         }
     } else {
         System.out.println("Invalid node position!");
     }
 }

 // delete node at head
 public void deleteAtHead() {
     if (head == null) {
         System.out.println("Circular linked list is empty!");
     } else if (head == tail) {
         // If there's only one node in the list, head and tail both become null
         head = tail = null;
     } else {
         // Otherwise, move the head pointer to the next node
         Node temp = head;
         head = head.next; // move head to the next node
         tail.next = head; // maintain the circular link
         temp = null;
     }
 }

 // delete node at tail
 public void deleteAtTail() {
     if (head == null) {
         System.out.println("Circular linked list is empty!");
     } else if (head == tail) {
         // If there's only one node in the list, head and tail both become null
         head = tail = null;
     } else {
         // More than one node
         Node current = head;
         while (current.next != tail) {
             current = current.next;
         }
         current.next = null;
         tail = current;
         tail.next = head; // add
     }
 }

 // deleting node between head and tail
 public void deleteAtPosition(int pos) {
     // if list is empty
     if (head == null) {
         System.out.println("Circular linked list is empty");
     }
     // if head is to be deleted
     else if (pos == 1) {
         // single node case
         if (head == tail) {
             // if there's only one node left
             head = null;
             tail = null;
         } else {
             // more than one node
             Node temp = head;
             head = head.next;
             tail.next = head; // Maintain the circular link
             temp = null;
         }
     } else if (pos > 1 && pos <= countNodes()) {
         Node prev = null, current = head;
         for (int i = 1; i < pos; i++) {
             prev = current;
             current = current.next;
         }
         // deleting last node
         if (current.next == head) { // change
             prev.next = null;
             tail = prev;
             tail.next = head; // maintain the circular link
         }
         // Delete specific node between head and tail
         else {
             prev.next = current.next;
         }
     } else {
         System.out.println("Invalid node position!");
     }
 }

 // function to display the data in the list
 public void displayList() {
     // Pointing the head to the node called current
     Node current = head;
     if (head == null) {
         System.out.println("The circular list is empty!");
         return;
     }
     System.out.println("The data in the given list are: ");
     while (true) { // change
         // Printing each data in the list and next pointer pointing to the next node
         System.out.print(current.data + " --> ");
         current = current.next;
         if (current == tail.next) {
             break; // add
         }
     }
     System.out.print("Null");
     System.out.println();
 }

 // Function to count total nodes
 public int countNodes() {
     int count = 0;
     Node current = head;
     if (head == null)
         return count; // add
     do { // change
         // Increment the count by 1 for each node
         current = current.next;
         count++;
     } while (current != head); // change
     return count;
 }

 // search key in linked list
 public void search(int key) {
     if (head == null) {
         System.out.println(key + " not found! The list is empty.");
     }
     Node current = head;
     int flag = 0;
     int pos = 1;
     do {
         if (current.data == key) {
             System.out.println("The " + key + " is found at " + pos + " position!");
             flag = 1;
         }
         current = current.next;
         pos++;
     } while (current != head);
     if (flag == 0) {
         System.out.println(key + " not found!");
     }
 }

 public static void main(String args[]) {
     CircularLinkedList cll = new CircularLinkedList();
     Scanner sc = new Scanner(System.in);
     int data, pos;
     int choice;
     do {
         System.out.println("\n1. Insert");
         System.out.println("2. Insert At Head");
         System.out.println("3. Insert At Tail");
         System.out.println("4. Insert At Position");
         System.out.println("5. Delete At Head");
         System.out.println("6. Delete at Tail");
         System.out.println("7. Delete At Position");
         System.out.println("8. Search for key");
         System.out.println("9. Total nodes");
         System.out.println("10. Display list");
         System.out.println("11. Exit");
         System.out.println("\nPlease Enter your choise: ");
         choice = sc.nextInt();
         switch (choice) {
             case 1:
                 System.out.println("Enter data: ");
                 data = sc.nextInt();
                 cll.insert(data);
                 cll.displayList();
                 break;
             case 2:
                 System.out.println("Insert Node at head - Enter data: ");
                 data = sc.nextInt();
                 cll.insertAtHead(data);
                 cll.displayList();
                 break;
             case 3:
                 System.out.println("Insert Node at Tail - Enter data: ");
                 data = sc.nextInt();
                 cll.insertAtTail(data);
                 cll.displayList();
                 break;
             case 4:
                 System.out.println("Insert Node at Position - Enter position: ");
                 pos = sc.nextInt();
                 System.out.println("Enter the data: ");
                 data = sc.nextInt();
                 cll.insertAtPosition(pos, data);
                 System.out.println();
                 cll.displayList();
                 break;
             case 5:
                 System.out.println("Delete node at head: ");
                 cll.deleteAtHead();
                 cll.displayList();
                 break;
             case 6:
                 System.out.println("Delete node at tail: ");
                 cll.deleteAtTail();
                 cll.displayList();
                 break;
             case 7:
                 System.out.println("Delete node at position - Enter position: ");
                 pos = sc.nextInt();
                 cll.deleteAtPosition(pos);
                 cll.displayList();
                 break;
             case 8:
                 System.out.println("Enter a key to search:");
                 int key = sc.nextInt();
                 cll.search(key);
                 break;
             case 9:
                 System.out.println("Total nodes in CLL: " + cll.countNodes());
                 break;
             case 10:
                 System.out.println("Print all nodes in CLL: ");
                 cll.displayList();
                 break;
             case 11:
                 System.out.println("Exiting the program.");
                 break;
             default:
                 System.out.println("You entered wrong choice!");
         }
     } while (choice != 11);
     sc.close();
 }
}