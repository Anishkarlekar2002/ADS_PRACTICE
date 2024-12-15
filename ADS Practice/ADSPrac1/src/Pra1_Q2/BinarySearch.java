package Pra1_Q2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the array size: ");
		int n= sc.nextInt();
		int [] arr = new int[n];
		
		System.out.println("Enter the element in sort order : ");
		for(int i=0;i<n;i++) {
			arr[i]  = sc.nextInt();
			
		}

System.out.println("enter the key to search :");

int key = sc.nextInt();

Arrays.sort(arr);
int result = binarySearch(arr,key,0,n-1);
if(result!=-1) {
	System.out.println("key is found at index "+result);
}else {
	System.out.println("key is not found");
}

sc.close();
	}

	private static int binarySearch(int[] arr, int key, int low, int high) {
		// TODO Auto-generated method stub
		if(low>high) {
			return -1;
		}
		int mid =low+(high-low)/2;
		if(arr[mid] == key) {
			return mid;
		}else if(arr[mid]>key){
			return binarySearch(arr, key, low, mid-1);
			
		}else {
			return binarySearch(arr, key, mid+1, high);
		}
		
		
		
	}
}
