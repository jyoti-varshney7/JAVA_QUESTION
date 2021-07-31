// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
// Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

// If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

// Input: [2, 7, 11, 15], target=9
// Output: index1 = 1, index2 = 2

// Input Format
// The first line of the input contains an integer n, denoting the size of the array.
// The next n inputs are the values of array.
// The next line contains an integer input for target.

// Constraints
// Output Format
// Return empty list, if no solution exists. Return an array containing indices(non zero based) of the two nos such that they add up to target.

// Sample Input
// 4
// 2 7 11 15
// 9
// Sample Output
// 1 2 
// Explanation
// Solution takes 0-index based approach:
// arr[0]+arr[1] = 9 i.e. (2+7)


import java.util.*;
import java.util.Map;
import java.util.HashMap;
public class Main {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        
        int[] p=new int[2];
        for(int i=0;i<n;i++){
            int search=target-arr[i];
            if(map.containsKey(search)){
                p[1]=i+1;
                p[0]=map.get(search)+1;
                break;
            }else{
                map.put(arr[i],i);
            } 
        }
         if(p[0]==0 && p[1]==0){
                System.out.print("-1");
            }else{
        for(int i=0;i<2;i++){
            System.out.print(p[i]+" ");
        }
        }
    }
}
