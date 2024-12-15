package Pra1_Q4;

import java.util.Scanner;

public class InsertionSort {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		System.out.println("Enter the element : ");
		for(int i=0;i<n-1;i++) {
			arr[i]=sc.nextInt();
					
		}
		InsertionSort(arr);
		System.out.println("Sorted elemeent array: ");
		for(int num :arr) {
			System.out.println(num+" ");
		}
		
		
		sc.close();
	}

	private static void InsertionSort(int[] arr) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<arr.length;i++) {
			int key=arr[i];
			int j =i-1;
			while(j>=0 && arr[j]>key) {
				arr[j + 1] = arr[j];
				j=j-1;
			}
			arr[j+1] = key;
			//System.out.println(key);
		}
	}
}
