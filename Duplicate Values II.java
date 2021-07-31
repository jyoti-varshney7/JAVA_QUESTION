// Kartik bhaiya gave monu an array 'nums' of n elements and an integer k .Find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k . monu is not good in maths help monu to solve the problem.
// Return true if nums[i] = nums[j] and the absolute difference between i and j is at most k,otherwise return false.

// Input Format
// First line contains integer n as size of array.
// Next N lines contains element of array.
// Last line contains value of k.

// Constraints
// None

// Output Format
// The output will be of the boolean form (true/false).

// Sample Input
// 4
// 1 
// 2 
// 3 
// 1
// 3
// Sample Output
// true
// Explanation
// None

import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
        int k = sc.nextInt();
		
        System.out.println(containsNearbyDuplicate(arr,k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0); // value,index
        
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && (i-map.get(nums[i]))<=k) // no need to use abs() because i's value will always be greater than map.get(nums[i]) value.
                return true;
            else
                map.put(nums[i],i);

        }   
        return false;
    }
}
