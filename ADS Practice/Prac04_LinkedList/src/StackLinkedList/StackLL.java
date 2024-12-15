package StackLinkedList;





//Q.5 Write a java program to demonstrate the working of Stack using Linked List.
//Java program to implement stack using singly linked list

class Node {
 int data;
 Node next;

 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

class Stack {
 Node head;

 Stack() {
     this.head = null;
 }

 Boolean isEmpty() {
     return head == null;
 }

 void push(int d) {
     Node newNode = new Node(d);
     if (newNode == null) {
         System.out.println("Stack overflow! (insufficient memory)");
     }
     newNode.next = head;
     head = newNode;
 }

 void pop() {
     if (isEmpty()) {
         System.out.println("Stack Underflow! (is empty!)");
         return;
     } else {
         Node temp = head;
         head = head.next;
         temp = null; // for memory deallocation
     }
 }

 int peek() {
     if (isEmpty()) {
         System.out.println("Stack Underflow! (is empty)");
         return Integer.MIN_VALUE;
         // return -1; // or you can write this also
     } else {
         return head.data;
     }
 }

 public void displayStack() {
     Node current = head;
     if (head == null) {
         System.out.println("Stack is empty!");
         return;
     }
     System.out.println("The data in stack: ");
     while (current != null) {
         System.out.print(current.data + " -> ");
         current = current.next;
     }
     System.out.print("null\n");
 }
}

public class StackLL {
 public static void main(String[] args) {
     Stack st = new Stack();
     st.push(10);
     st.push(20);
     st.push(30);
     st.push(40);
     st.push(50);
     st.displayStack();
     System.out.println("The topmost element is " + st.peek());
     System.out.println("Removing two element...");
     st.pop();
     st.pop();
     st.displayStack();
     System.out.println("The topmost element is " + st.peek());
 }
}