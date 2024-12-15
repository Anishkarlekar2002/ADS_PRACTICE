package bst;

import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

//java program to implement binary serach tree using doublylinked list
//method -create, recursively traversal : inorder, preorder, postorder
//serach largest Node, smallest Node count number of nodes

class Node{
	Node right,left;
	int data;

	public Node(int data) {
		right=left=null;
		this.data= data;	

	}
}


public class BinarySerachTree {

	private Node root;
	static int count =0;

	public BinarySerachTree() {
		this.root = null;

	}

	public static int nodeCounts() {
		return count;
	}


	//Insert a node into the binary tree 
	public void insertNode(int val) {

		Node newNode = new Node(val);

		if( root == null) {
			root = newNode;
			count ++;
		}else {

			Node trav = root;
			Node hold = null;

			while(trav !=null) {
				hold= trav;
				if(val > trav.data) {
					trav = trav.right;
				}
				else if(val < trav.data){
					trav = trav.left;
				}
				else {
					System.out.println("Duplicate data");
					return;
				}
			}
			if(val > hold.data)
				hold.right = newNode ;
			else
				hold.left = newNode;
			count++;

		}
	}

	//In-order traversal
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public void inorder() {
		inorder(root);
	}

	//pre-order traversal
	public void preorder(Node root) {
		if(root!=null) {
			if(root != null) {
				System.out.print(root.data + " ");
				preorder(root.left);
				preorder(root.right);
			}
		}

	}
	public void preorder() {
		preorder(root);
	}

	//post-order traversal

	public void postorder(Node root) {
		if(root!=null) {
			if(root != null) {
				postorder(root.left);
				postorder(root.right);
				System.out.print(root.data + " ");
			}
		}

	}
	public void postorder() {
		postorder(root);
	}

	//find the smallest element

	public void smallest() {
		Node trav = root;
		if(trav == null) {
			System.out.println("Tree is empty !");
			return;
		}
		while(trav.left !=null) 
			trav =trav.left;

		System.out.println("Smallest Node is: " + trav.data);



	}


	//find the largest element
	public void largest() {
		Node trav = root;
		if(trav == null) {
			System.out.println("Tree is empty !");
			return;
		}
		while(trav.left !=null) 
			trav =trav.right;

		System.out.println("largest Node is: " + trav.data);



	}

	//serach for a vllue in the tree
	public void search( int val) {
		Node trav = root;
		while(trav !=null) {
			if(val > trav.data)
				trav = trav.right;
			else if( val < trav.data)
				trav = trav.left;
			else {
				System.out.println("Node with data "+val + " is found.");
				return;
			}
		}
		System.out.println("Node with data "+ val + " is not found!");
	}
	
	//remove a ndoe from the tree
	public void removeNode(int val) {
		root = removeNodeRecursive(root, val);
		if(root != null)
			count--;
	}
	
	public Node removeNodeRecursive(Node root, int val) {
		if(root == null) {
			System.out.println("Node not found! ");
			return root;
		}
		if(val < root.data) {
			root.left = removeNodeRecursive(root.left, val);
		}
		else if(val > root.data) {
			root.right = removeNodeRecursive(root.right, val);
		}
		else {
			//Node with one child or no  child
			if(root.left == null)
				return root.right;
			else if( root.right == null)
				return root.left;
			
			//Node with two childreen : get the inorder predecessor
			Node trav = root.left;
			while(trav.right != null)
				trav = trav.right;
			
			root.data =  trav.data;
			root.left = removeNodeRecursive(root.left, root.data);
		}
		return root;
	}
	

	 public static void main(String[] args) {
		 BinarySerachTree bt = new BinarySerachTree();
	        //45,39,56,12,34,78,32,10,89,54,67,81
	        
	        Scanner sc = new Scanner(System.in);

	    	int data;
	        
	        int choice;

	        System.out.print("\nBinary Search Tree\n\n");
	    	do
	    	{
	    		System.out.print("\n1.Insert Node\n");
	    		System.out.print("2.InOrder Traversal\n");
	    		System.out.print("3.PreOrder Traversal\n");
	    		System.out.print("4.PostOrder Traversal\n");
	    		System.out.print("5.Smallest Node\n");
	    		System.out.print("6.Largest Node\n");
	    		System.out.print("7.Count Nodes\n");
//	    		System.out.print("8.Remove Node\n");
//	    		System.out.print("9.Search Node\n");
	    		System.out.print("10.Exit\n");
	    		System.out.print("Enter your choice : ");
	    		choice = sc.nextInt();
	    		switch (choice)
	    		{
	    		case 1: System.out.print("\nInsert Node - Enter data : ");
	    				data= sc.nextInt();
	    				bt.insertNode(data);
	    				break;
	    		case 2: System.out.print("\nInOrder Traversal : ");
						bt.inorder();
						break;
	    		case 3: System.out.print("\nPreOrder Traversal : ");
						bt.preorder();
	    				break;
	    		case 4: System.out.print("\nPostOrder Traversal : ");
						bt.postorder();
						break;
	    		case 5: System.out.print("\nSmallest node is : ");
	    				bt.smallest();
						break;
	    		case 6: System.out.print("\nLargest node is : ");
						bt.largest();
						break;  
	    		case 7: System.out.print("\nTotal node count : " + nodeCounts());
						break;
	    		case 8: System.out.print("\nRemove node - Enter key : ");
						data=sc.nextInt();
	    				bt.removeNode(data);
						break;
	    		case 9: System.out.print("\nSearch node - Enter Data : ");
	    				data=sc.nextInt();
	    				bt.search(data);
						break;
	    		case 10: System.out.println("Exiting the program.");  
	    				break;
	    		default:
	    			System.out.print("\nWrong choice! \n");
	    			
	    		} /*End of switch*/
	    	}while(choice!=10); /*End of while*/
	    	sc.close();
	       
	        // Insert nodes
	        bt.insertNode(45);
	        bt.insertNode(39);
	        bt.insertNode(56);
	        bt.insertNode(12);
	        bt.insertNode(34);
	        bt.insertNode(78);
	        bt.insertNode(32);
	        bt.insertNode(10);
	        bt.insertNode(89);
	        bt.insertNode(54);
	        bt.insertNode(67);
	        bt.insertNode(81);

	        // Traversals
	        System.out.print("Inorder: ");
	        bt.inorder();
	        System.out.print("\nPreorder: ");
	        bt.preorder();
	        System.out.print("\nPostorder: ");
	        bt.postorder();

	        // Smallest and Largest elements
	        System.out.println();
	        bt.smallest();
	        bt.largest();

	        // Search for elements
	        bt.search(99);
	        bt.search(56);

	        // Remove nodes
	        System.out.println("\nRemoving element 5");
	        bt.removeNode(5);
	        System.out.println("Removing element 54");
	        bt.removeNode(54);

	        // Inorder after deletions
	        System.out.print("Inorder: ");
	        bt.inorder(); 
	    }   

	
}


//BOTH CODE ARE CORRECT UUPER AND BELLOW
////////////////////////////////////////////////////////////////////////
//package bst;
//
//import java.util.Scanner;
//
//// Java program to implement binary search tree using doubly linked list
//// Methods: Create, recursively traverse (inorder, preorder, postorder),
//// Search largest node, smallest node, count number of nodes, remove node.
//
//class Node {
//    Node right, left;
//    int data;
//
//    public Node(int data) {
//        right = left = null;
//        this.data = data;
//    }
//}
//
//public class BinarySearchTree {
//
//    private Node root;
//    static int count = 0;
//
//    public BinarySearchTree() {
//        this.root = null;
//    }
//
//    public static int nodeCounts() {
//        return count;
//    }
//
//    // Insert a node into the binary tree
//    public void insertNode(int val) {
//        Node newNode = new Node(val);
//
//        if (root == null) {
//            root = newNode;
//            count++;
//        } else {
//            Node trav = root;
//            Node hold = null;
//
//            while (trav != null) {
//                hold = trav;
//                if (val > trav.data) {
//                    trav = trav.right;
//                } else if (val < trav.data) {
//                    trav = trav.left;
//                } else {
//                    System.out.println("Duplicate data");
//                    return;
//                }
//            }
//            if (val > hold.data)
//                hold.right = newNode;
//            else
//                hold.left = newNode;
//            count++;
//        }
//    }
//
//    // In-order traversal
//    public void inorder(Node root) {
//        if (root != null) {
//            inorder(root.left);
//            System.out.print(root.data + " ");
//            inorder(root.right);
//        }
//    }
//
//    public void inorder() {
//        inorder(root);
//    }
//
//    // Pre-order traversal
//    public void preorder(Node root) {
//        if (root != null) {
//            System.out.print(root.data + " ");
//            preorder(root.left);
//            preorder(root.right);
//        }
//    }
//
//    public void preorder() {
//        preorder(root);
//    }
//
//    // Post-order traversal
//    public void postorder(Node root) {
//        if (root != null) {
//            postorder(root.left);
//            postorder(root.right);
//            System.out.print(root.data + " ");
//        }
//    }
//
//    public void postorder() {
//        postorder(root);
//    }
//
//    // Find the smallest element
//    public void smallest() {
//        Node trav = root;
//        if (trav == null) {
//            System.out.println("Tree is empty!");
//            return;
//        }
//        while (trav.left != null)
//            trav = trav.left;
//
//        System.out.println("Smallest node is: " + trav.data);
//    }
//
//    // Find the largest element
//    public void largest() {
//        Node trav = root;
//        if (trav == null) {
//            System.out.println("Tree is empty!");
//            return;
//        }
//        while (trav.right != null)
//            trav = trav.right; // Fixed traversal to the right subtree.
//
//        System.out.println("Largest node is: " + trav.data);
//    }
//
//    // Search for a value in the tree
//    public void search(int val) {
//        Node trav = root;
//        while (trav != null) {
//            if (val > trav.data)
//                trav = trav.right;
//            else if (val < trav.data)
//                trav = trav.left;
//            else {
//                System.out.println("Node with data " + val + " is found.");
//                return;
//            }
//        }
//        System.out.println("Node with data " + val + " is not found!");
//    }
//
//    // Remove a node from the tree
//    public void removeNode(int val) {
//        root = removeNodeRecursive(root, val);
//    }
//
//    public Node removeNodeRecursive(Node root, int val) {
//        if (root == null) {
//            System.out.println("Node not found!");
//            return root;
//        }
//        if (val < root.data) {
//            root.left = removeNodeRecursive(root.left, val);
//        } else if (val > root.data) {
//            root.right = removeNodeRecursive(root.right, val);
//        } else {
//            // Node with one child or no child
//            if (root.left == null)
//                return root.right;
//            else if (root.right == null)
//                return root.left;
//
//            // Node with two children: get the inorder predecessor
//            Node trav = root.left;
//            while (trav.right != null)
//                trav = trav.right;
//
//            root.data = trav.data;
//            root.left = removeNodeRecursive(root.left, root.data);
//        }
//        count--; // Decrement count after successful deletion.
//        return root;
//    }
//
//    public static void main(String[] args) {
//        BinarySearchTree bt = new BinarySearchTree();
//        Scanner sc = new Scanner(System.in);
//        int data;
//        int choice;
//
//        System.out.print("\nBinary Search Tree\n\n");
//        do {
//            System.out.print("\n1.Insert Node\n");
//            System.out.print("2.InOrder Traversal\n");
//            System.out.print("3.PreOrder Traversal\n");
//            System.out.print("4.PostOrder Traversal\n");
//            System.out.print("5.Smallest Node\n");
//            System.out.print("6.Largest Node\n");
//            System.out.print("7.Count Nodes\n");
//            System.out.print("8.Remove Node\n");
//            System.out.print("9.Search Node\n");
//            System.out.print("10.Exit\n");
//            System.out.print("Enter your choice: ");
//            choice = sc.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.print("\nInsert Node - Enter data: ");
//                    data = sc.nextInt();
//                    bt.insertNode(data);
//                    break;
//                case 2:
//                    System.out.print("\nInOrder Traversal: ");
//                    bt.inorder();
//                    break;
//                case 3:
//                    System.out.print("\nPreOrder Traversal: ");
//                    bt.preorder();
//                    break;
//                case 4:
//                    System.out.print("\nPostOrder Traversal: ");
//                    bt.postorder();
//                    break;
//                case 5:
//                    bt.smallest();
//                    break;
//                case 6:
//                    bt.largest();
//                    break;
//                case 7:
//                    System.out.print("\nTotal node count: " + nodeCounts());
//                    break;
//                case 8:
//                    System.out.print("\nRemove node - Enter key: ");
//                    data = sc.nextInt();
//                    bt.removeNode(data);
//                    break;
//                case 9:
//                    System.out.print("\nSearch node - Enter Data: ");
//                    data = sc.nextInt();
//                    bt.search(data);
//                    break;
//                case 10:
//                    System.out.println("Exiting the program.");
//                    break;
//                default:
//                    System.out.print("\nWrong choice!\n");
//            }
//        } while (choice != 10);
//        sc.close();
//    }
//}
///////////////////////////////////////////////////////////////