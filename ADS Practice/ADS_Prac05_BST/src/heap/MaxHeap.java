package heap;



class Node{
	Node prev,next;
	int data;

	public Node(int data) {
		prev=next=null;
		this.data= data;	

	}
}

public class MaxHeap {

	
	Node head,tail;
	
	public MaxHeap() {
		this.head = null;
		this.tail = null;
	}
	
	//reheap up for maxheap
	
	private void reheapUp(Node node) {
		Node parent = getParent(node);
		
		while(parent != null && node.data > parent.data) {
			//change
			//swap the node with its parent
			int temp = node.data;
			node.data =  parent.data;
			parent.data = temp;
			
			node=parent;
			parent = getParent(node);
		}
	}
	
	//reheap down for maxheap
	private void reheapDown(Node node) {
		while(node != null) {
			Node leftChild = node.next;
			Node rightChild = (leftChild != null) ? leftChild.next : null;
			
			
			//if there  are no children , break out of the loop
			if(leftChild == null) {
				break;
			}
			
			Node maxChild = leftChild;//chnage
			if(rightChild != null && rightChild.data > leftChild.data) {
				//change
				maxChild = rightChild;//change
			}
			
			//if thenode is greater than or equal to its largest child stop
			if(node.data >= maxChild.data) {
				// change
				break;
				
			}
			//swap node with the largest child
			int temp = node.data;
			node.data = maxChild.data;//change
			maxChild.data = temp; //chnage
			node = maxChild; //change
		}
	}
	//Insert a ndoe in the MaxHeao
	public void insert(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			//reheap up from the last inserted mode
			reheapUp(newNode);
		}
	}
	
	//Delete the root node in the Maxheao
	public void delete() {
		if(head == null) {
			System.out.println("Heap is empty! ");
			return;
		}
		Node lastNode = tail;
		
		//Move the last node to the root position
		head.data = lastNode.data;
		
		
		//remove the last node
		if(tail.prev != null) {
			tail = tail.prev;
			tail.next = null;
		}else {
			head = null;
		}
		//reheap down from the root
		reheapDown(head);
		
	}
	
	//get the parent of a node in the doubly linked list
	private Node getParent(Node node) {
		return node.prev;
	}
	
	////print the heap
	public void printHeap() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp =  temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();
		
		//insert calues into maxheap
		System.out.println("\nInserting values into MaxHeap :");
		maxHeap.insert(10);
		maxHeap.insert(20);
		maxHeap.insert(5);
		maxHeap.insert(8);
		maxHeap.printHeap(); // print the heap in valid maxheap order
		//delete root from maxheap
		System.out.println("Deleting root node from maxHeap: ");
		maxHeap.delete();
		maxHeap.printHeap(); // should print the heap after root node deletion
				
	}
}
