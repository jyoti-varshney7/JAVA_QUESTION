// Take as input N, the size of array. Take N more inputs and store that in an array. Write a recursive function which returns true if the array is sorted and false otherwise. Print the value returned.

// Input Format
// Enter a number N and take N more inputs and store in an array

// Constraints
// None

// Output Format
// Display the Boolean result

// Sample Input
// 4
// 1
// 2
// 3
// 4
// Sample Output
// true

import java.util.*;
public class Main {
    static int arraySortedOrNot(int arr[], int n)
    {
        if (n == 1 || n == 0)
            return 1;

        if (arr[n - 1] < arr[n - 2])
            return 0;

        return arraySortedOrNot(arr, n - 1);
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        if(arraySortedOrNot(arr , n)!= 0)
              System.out.println("true");
        else
            System.out.println("false");
        
    }
}
