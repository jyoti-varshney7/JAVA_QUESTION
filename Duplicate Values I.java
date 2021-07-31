// Given an array of n elements, check if the array contains any duplicates.
// The function should return true if there are duplicates,otherwise return false.

// Input Format
// First line contains integer n as size of array.
// Next line contains a n integer as element of array.

// Constraints
// None

// Output Format
// The output will be of the boolean form.

// Sample Input
// 4
// 1 2 3 1
// Sample Output
// true
// Explanation
// None


import java.util.*;
public class Main {
	public static boolean checkDuplicatesWithinK(int arr[], int k)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++)
        {
            if (set.contains(arr[i]))
               return true;
 
            set.add(arr[i]);
 
            if (i >= k)
              set.remove(arr[i-k]);
        }
        return false;
    }
 public static void main (String[] args)
    {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
        if (checkDuplicatesWithinK(arr, 3))
           System.out.println("true");
        else
           System.out.println("false");
    }
}
