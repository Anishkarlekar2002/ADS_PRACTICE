package heap;

//class Node {
//    Node prev, next;
//    int data;
//
//    public Node(int data) {
//        prev = next = null;
//        this.data = data;
//    }
//}

public class MinHeap {

    Node head, tail;

    public MinHeap() {
        this.head = null;
        this.tail = null;
    }

    // Reheap up for MinHeap
    private void reheapUp(Node node) {
        Node parent = getParent(node);

        while (parent != null && node.data < parent.data) { // Compare for MinHeap
            // Swap the node with its parent
            int temp = node.data;
            node.data = parent.data;
            parent.data = temp;

            node = parent;
            parent = getParent(node);
        }
    }

    // Reheap down for MinHeap
    private void reheapDown(Node node) {
        while (node != null) {
            Node leftChild = node.next;
            Node rightChild = (leftChild != null) ? leftChild.next : null;

            // If there are no children, break out of the loop
            if (leftChild == null) {
                break;
            }

            // Find the smaller child
            Node minChild = leftChild; // Assume leftChild is smaller
            if (rightChild != null && rightChild.data < leftChild.data) {
                minChild = rightChild; // Choose rightChild if smaller
            }

            // If the node is smaller than or equal to its smallest child, stop
            if (node.data <= minChild.data) {
                break;
            }

            // Swap the node with the smallest child
            int temp = node.data;
            node.data = minChild.data;
            minChild.data = temp;

            node = minChild;
        }
    }

    // Insert a node in the MinHeap
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            // Reheap up from the last inserted node
            reheapUp(newNode);
        }
    }

    // Delete the root node in the MinHeap
    public void delete() {
        if (head == null) {
            System.out.println("Heap is empty!");
            return;
        }
        Node lastNode = tail;

        // Move the last node to the root position
        head.data = lastNode.data;

        // Remove the last node
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
        }
        // Reheap down from the root
        reheapDown(head);
    }

    // Get the parent of a node in the doubly linked list
    private Node getParent(Node node) {
        Node temp = head;
        int index = 0;
        while (temp != node) {
            temp = temp.next;
            index++;
        }
        int parentIndex = (index - 1) / 2;
        temp = head;
        for (int i = 0; i < parentIndex; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Print the heap
    public void printHeap() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Insert values into MinHeap
        System.out.println("\nInserting values into MinHeap:");
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.printHeap(); // Print the heap in valid MinHeap order

        // Delete root from MinHeap
        System.out.println("Deleting root node from MinHeap:");
        minHeap.delete();
        minHeap.printHeap(); // Should print the heap after root node deletion
    }
}
