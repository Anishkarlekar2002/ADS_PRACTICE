package linear_Probe_collisionResolution;


import java.util.Scanner;

public class HashTable {

    private int[] hashTable; // Array to store hash values
    private int tableSize; // Size of the hash table

    // Constructor to initialize the hash table
    public HashTable(int size) {
        tableSize = size;
        hashTable = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = -1; // Initialize all slots as empty (-1)
        }
    }

    // Function to calculate hash using modulo division
    private int hashFunction(int key) {
        return key % tableSize;
    }

    // Function to insert a key into the hash table
    public void insert(int key) {
        int hashIndex = hashFunction(key);

        // Linear probing for collision resolution
        while (hashTable[hashIndex] != -1) {
            System.out.println("Collision detected at index " + hashIndex + " for key " + key + ". Resolving using linear probing.");
            hashIndex = (hashIndex + 1) % tableSize; // Move to the next slot
        }

        hashTable[hashIndex] = key; // Place the key in the resolved index
        System.out.println("Key " + key + " inserted at index " + hashIndex);
    }

    // Function to display the hash table
    public void displayHashTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Index " + i + ": " + (hashTable[i] == -1 ? "Empty" : hashTable[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the hash table size
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();

        // Create a hash table
        HashTable hashing = new HashTable(size);

        // Menu-driven program
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a key");
            System.out.println("2. Display the hash table");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key to insert: ");
                    int key = scanner.nextInt();
                    hashing.insert(key);
                    break;

                case 2:
                    hashing.displayHashTable();
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
