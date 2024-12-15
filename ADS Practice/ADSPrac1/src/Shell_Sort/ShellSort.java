package Shell_Sort;




import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShellSort {
    public static void shellSort(int[] arr, int n) {
        int pass = 1;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i]; // storing gap element in temp
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap]; // moving element if it is greater
                }

                arr[j] = temp; // placing temp element at appropriate position
            }

            System.out.println("\nGap = " + gap + "\nPass " + pass + " : ");
            for (int i = 0; i < n; i++) {
                System.out.print(" " + arr[i] + " ");
            }
            pass++;
        }
    }

    public static void main(String[] args) {
        int size = 15;
        int[] myArray = new int[size];

        // Opening the file in read mode
        try {
            Scanner infile = new Scanner(new File("D:\\MCA\\ADS Practice\\ADSPrac1\\src\\Shell_Sort\\num.txt"));

            // Reading the values from the file and storing in array
            for (int i = 0; i < size; ++i) {
                myArray[i] = infile.nextInt();
            }

            // Closing the file
            infile.close();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open file for reading.");
            return;
        }

        System.out.println("\nArray before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(myArray[i] + " ");
        }

        shellSort(myArray, size);

        System.out.println("\nArray after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}