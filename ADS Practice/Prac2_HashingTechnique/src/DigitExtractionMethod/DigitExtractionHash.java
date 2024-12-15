package DigitExtractionMethod;

import java.util.Scanner;

class HashTable {

    private Integer[] table;
    private int size;

    // Constructor to initialize the hash table
    public HashTable(int size) {
        this.size = size;
        table = new Integer[size];
    }

    // Digit-Extraction Hashing: Extract specific digits from the key to calculate the hash
    private int hash(int key) {
        String keyStr = Integer.toString(key); // Convert the key to a string
        int length = keyStr.length();

        if (length < 2) {
            // If key has fewer than 2 digits, use the only digit
            return key % size;
        } else {
            // Extract specific digits (e.g., first and last digits)
            int firstDigit = Character.getNumericValue(keyStr.charAt(0));
            int lastDigit = Character.getNumericValue(keyStr.charAt(length - 1));

            // Combine the extracted digits (e.g., sum or multiply) to generate a hash
            return (firstDigit + lastDigit) % size;
        }
    }

    // Insert a key into the hash table using linear probing
    public void insert(int key) {
        int index = hash(key);

        // Handle collisions with linear probing
        while (table[index] != null) {
            index = (index + 1) % size; // Move to the next slot
        }
        table[index] = key;
    }

    // Display the hash table
    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}

public class DigitExtractionHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the hash table size
        System.out.print("Enter the size of the hash table: ");
        int size = sc.nextInt();

        // Create a hash table
        HashTable hashtable = new HashTable(size);

        // Get the number of keys to hash
        System.out.print("Enter the number of keys to hash: ");
        int numKeys = sc.nextInt();

        // Insert each key into the hash table
        System.out.println("Enter the keys:");
        for (int i = 0; i < numKeys; i++) {
            int key = sc.nextInt();
            hashtable.insert(key);
        }

        // Display the hash table
        hashtable.display();

        sc.close();
    }
}
