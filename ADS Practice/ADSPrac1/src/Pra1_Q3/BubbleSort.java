package Pra1_Q3;

import java.util.Scanner;

public class BubbleSort {
 public  static void bubbleSort(int [] arr) {
	 for(int i=0;i<arr.length;i++) {
		 for(int j=0;j<arr.length-i-1;j++) {
		if(arr[j]>arr[j+1]) {
			int temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1]  = temp;
		}
		 }
	 }
	 
	
 }
 public static void main(String[] args) {
	 Scanner sc= new Scanner(System.in);
	 System.out.println("enter the arr size: ");
	 int n=sc.nextInt();
	int [] arr =new int[n];
	System.out.println("enter the element:");
	for(int i=0;i<n;i++) {
		arr[i] = sc.nextInt();
	}
	
	bubbleSort(arr);
	
	System.out.println("sorted array: ");
	for(int num : arr) {
		System.out.print(num+" ");
	}
	System.out.println();
}
}
