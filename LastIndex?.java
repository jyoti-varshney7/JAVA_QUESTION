// Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, a number. Write a recursive function which returns the last index at which M is found in the array and -1 if M is not found anywhere. Print the value returned.

// Input Format
// Enter a number N and add N more numbers to an array, then enter number M to be searched

// Constraints
// None

// Output Format
// Display the last index at which the number M is found

// Sample Input
// 5
// 3
// 2
// 1
// 2
// 3
// 2
// Sample Output
// // 3

import java.util.*;
public class Main {
    public static int classAssignment(int[] arr,int i,int m){
        if( i == -1){
            //System.out.print(arr[i] + " ");
            return -1;
        }
        if(arr[i] == m){
            //System.out.print(i);
            return i ;
        }
        int recAns = classAssignment(arr ,i-1 ,m);
        //System.out.print(arr[i] + " ");
        return recAns;
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        System.out.println(classAssignment(arr , n-1 , m));
        //System.out.println(m);
    }
}
