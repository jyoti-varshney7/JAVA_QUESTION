// Take as input N, a number. Take N more inputs and store that in an array. Write a recursive function which reverses the array. Print the values of reversed array.

// Input Format
// Enter a number N and take N more inputs

// Constraints
// None

// Output Format
// Display values of the reversed array

// Sample Input
// 4
// 1
// 2
// 3
// 4
// Sample Output
// 4 3 2 1

import java.util.*;
public class Main {
    public static void classAssignment(int[] arr,int n,int i){
        if( i == n){
            System.out.print(arr[i] + " ");
            return;
        }
        classAssignment(arr , n,i+1);
        System.out.print(arr[i] + " ");
        return;
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        classAssignment(arr , n-1,0);
    }
}
