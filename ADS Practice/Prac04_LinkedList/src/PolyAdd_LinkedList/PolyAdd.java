package PolyAdd_LinkedList;



//Q.4 Write a java program to perform addition of two polynomials using Linked List.

class Node {
 int coeff;
 int pow;
 Node next;

 // Constructor to initialize a node with coefficient and power
 Node(int c, int p) {
     coeff = c;
     pow = p;
     next = null;
 }
}

public class PolyAdd {

 // Function to add two polynomials represented by linked lists
 static Node addPolynomial(Node head1, Node head2) {
     // If the first polynomial is empty, return the second polynomial
     if (head1 == null) {
         return head2;
     }

     // If the second polynomial is empty, return the first polynomial
     if (head2 == null) {
         return head1;
     }

     // If the power of first polynomial is greater than the second
     if (head1.pow > head2.pow) {
         Node nextPtr = addPolynomial(head1.next, head2);
         head1.next = nextPtr;
         return head1;
     }

     // If the power of second polynomial is greater than the first
     else if (head1.pow < head2.pow) {
         Node nextPtr = addPolynomial(head1, head2.next);
         head2.next = nextPtr;
         return head2;
     }

     // If the powers are equal, add the coefficients
     Node nextPtr = addPolynomial(head1.next, head2.next);
     head1.coeff = head1.coeff + head2.coeff;
     return head1;
 }

 // Function to print the polynomial linked list
 static void printList(Node head) {
     Node temp = head;
     while (temp != null) {
         System.out.print(temp.coeff + "x" + temp.pow + " --> ");
         temp = temp.next;
     }
     System.out.println("Null\n");
 }

 public static void main(String[] args) {
     // First polynomial: 4x^3 + 3x^2 + 3x^0
     Node head1 = new Node(4, 3);
     head1.next = new Node(3, 2);
     head1.next.next = new Node(3, 0);

     // Second polynomial: 2x^1 - 7x^0
     Node head2 = new Node(2, 1);
     head2.next = new Node(-7, 0);

     // Add the two polynomials
     Node head = addPolynomial(head1, head2);

     // Print the result
     System.out.println("The addition of two polynomial equations is: ");
     printList(head);
 }
}