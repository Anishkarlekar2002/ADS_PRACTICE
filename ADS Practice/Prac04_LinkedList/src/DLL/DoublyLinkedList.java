package DLL;
//Q.3 Write a java program to demonstrate the working of Doubly Linked List.

//Java program to implement Doubly Linked List
//Methods - displayList, isEmpty, insert, insertAtHead, insertAtTail
//insertAtPosition, deleteAtHead, deleteAtTail, deleteAtPosition
//countNodes, search

import java.util.Scanner;

class Node {
  int data;
  Node prev; // previous pointer for doubly linked list
  Node next; // next pointer for doubly linked list

  // Constructor to initialize the node with data
  public Node(int data) {
      this.data = data;
      this.prev = null; // previous node is initially null
      this.next = null; // next node is initially null
  }
}

public class DoublyLinkedList {
  // Defining the head and tail of the doubly linked list
  Node head;
  Node tail;

  // Constructor to initialize the list as empty
  public DoublyLinkedList() {
      head = null;
      tail = null;
  }

  // Function to check if the list is empty
  public boolean isEmpty() {
      return (head == null);
  }

  // Function to add a node to the end of the list
  public void insert(int data) {
      Node newNode = new Node(data);
      // If the list is empty, head and tail will point to the new node
      if (head == null) {
          head = newNode;
          tail = newNode;
      } else {
          // Otherwise, add the new node at the end and update tail
          tail.next = newNode;
          newNode.prev = tail;
          tail = newNode;
      }
  }

  // Function to add a node at the head of the list
  public void insertAtHead(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          tail = newNode;
      } else {
          newNode.next = head; // Next of new node will point to head
          head.prev = newNode; // Previous of head will point to new node
          head = newNode; // Move head to the new node
      }
  }

  // Function to add a node at the tail of the list
  public void insertAtTail(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          tail = newNode;
      } else {
          tail.next = newNode;
          newNode.prev = tail;
          tail = newNode;
      }
  }

  // Function to insert a node at a specific position in the list
  public void insertAtPosition(int pos, int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          tail = newNode;
      } else if (pos == 1) {
          newNode.next = head;
          head.prev = newNode;
          head = newNode;
      } else {
          Node current = head;
          int currPos = 1;
          while (current != null && currPos < pos) {
              current = current.next;
              currPos++;
          }
          if (current == null) {
              tail.next = newNode;
              newNode.prev = tail;
              tail = newNode;
          } else {
              newNode.next = current;
              newNode.prev = current.prev;
              current.prev.next = newNode;
              current.prev = newNode;
          }
      }
  }

  // Function to delete a node from the head of the list
  public void deleteAtHead() {
      if (head == null) {
          System.out.println("Doubly linked list is empty!");
      } else if (head == tail) {
          head = tail = null;
      } else {
          Node temp = head;
          head = head.next;
          head.prev = null;
          temp = null;
      }
  }

  // Function to delete a node from the tail of the list
  public void deleteAtTail() {
      if (head == null) {
          System.out.println("Doubly linked list is empty!");
      } else if (head == tail) {
          head = tail = null;
      } else {
          Node temp = tail;
          tail = tail.prev;
          tail.next = null;
          temp.prev = null;
      }
  }

  // Function to delete a node from a specific position in the list
  public void deleteAtPosition(int pos) {
      Node current = head;
      int totalNodes = countNodes();
      if (head == null) {
          System.out.println("Doubly linked list is empty");
      } else if (pos == 1) {
          if (head == tail) {
              head = null;
              tail = null;
          } else {
              Node temp = head;
              head = head.next;
              head.prev = null;
              temp = null;
          }
      } else if (pos > 1 && pos <= totalNodes) {
          if (pos == totalNodes) {
              Node temp = tail;
              tail = tail.prev;
              tail.next = null;
              temp.prev = null;
          } else {
              for (int i = 1; i < pos; i++) {
                  current = current.next;
              }
              current.prev.next = current.next;
              current.next.prev = current.prev;
              current.prev = null;
              current.next = null;
          }
      } else {
          System.out.println("Invalid node position!");
      }
  }

  // Function to display all nodes in the list
  public void displayList() {
      Node current = head;
      if (head == null) {
          System.out.println("The list is empty!");
          return;
      }
      System.out.println("The data in the given list are: ");
      while (current != null) {
          System.out.print(current.data + " <--> ");
          current = current.next;
      }
      System.out.println("Null");
  }

  // Function to count the total number of nodes in the list
  public int countNodes() {
      int count = 0;
      Node current = head;
      while (current != null) {
          count++;
          current = current.next;
      }
      return count;
  }

  // Function to search for a specific key in the list
  public void search(int key) {
      Node current = head;
      int pos = 1;
      boolean found = false;
      while (current != null) {
          if (current.data == key) {
              System.out.println("The " + key + " is found at position " + pos + "!");
              found = true;
              break;
          }
          current = current.next;
          pos++;
      }
      if (!found) {
          System.out.println(key + " not found!");
      }
  }

  // Main method to interact with the program
  public static void main(String args[]) {
      DoublyLinkedList dll = new DoublyLinkedList();
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
          System.out.print("\nPlease Enter your choice: ");
          choice = sc.nextInt();
          switch (choice) {
              case 1:
                  System.out.print("Enter data: ");
                  data = sc.nextInt();
                  dll.insert(data);
                  dll.displayList();
                  break;
              case 2:
                  System.out.print("Insert Node at head - Enter data: ");
                  data = sc.nextInt();
                  dll.insertAtHead(data);
                  dll.displayList();
                  break;
              case 3:
                  System.out.print("Insert Node at Tail - Enter data: ");
                  data = sc.nextInt();
                  dll.insertAtTail(data);
                  dll.displayList();
                  break;
              case 4:
                  System.out.print("Insert Node at Position - Enter position: ");
                  pos = sc.nextInt();
                  System.out.print("Enter the data: ");
                  data = sc.nextInt();
                  dll.insertAtPosition(pos, data);
                  dll.displayList();
                  break;
              case 5:
                  dll.deleteAtHead();
                  dll.displayList();
                  break;
              case 6:
                  dll.deleteAtTail();
                  dll.displayList();
                  break;
              case 7:
                  System.out.print("Delete node at position - Enter position: ");
                  pos = sc.nextInt();
                  dll.deleteAtPosition(pos);
                  dll.displayList();
                  break;
              case 8:
                  System.out.print("Enter a key to search: ");
                  int key = sc.nextInt();
                  dll.search(key);
                  break;
              case 9:
                  System.out.println("Total nodes in DLL: " + dll.countNodes());
                  break;
              case 10:
                  dll.displayList();
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