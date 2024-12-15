package Pra1_Q1;

import java.util.Scanner;

public class SequenceSearch {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the array size: ");
	int n= sc.nextInt();
	int [] numbers = new int[n];
	
	System.out.println("enter the element of the array: ");
	for(int i=0;i<n;i++) {
		numbers[i] = sc.nextInt();
	}
	System.out.println("Enter the key to search: ");
	int key = sc.nextInt();
	int result =SequenceSearch(numbers,key);
	
	if(result!=-1) {
		System.out.println("key is "+numbers[result] + " found at index "+result);
	}else {
		System.out.println("key is not found ");
	}
	
}

private static int SequenceSearch(int[] numbers, int key) {
	// TODO Auto-generated method stub
	for(int i=0;i<numbers.length;i++) {
		if(numbers[i] == key) {
			return i;
		}
		
	}
	return -1;
	
}
}
