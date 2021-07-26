// Reaching to the top of a staircase, it takes n steps.
// The task can be accomplished either by climbing 1 step or 2 steps at a time.
// In how many different ways can you climb to the top.
// Note: n will be a positive integer.

// Input Format
// First line contains an integer n.

// Constraints
// None

// Output Format
// Print the total number of distinct ways you can climb to top.

// Sample Input
// 2
// Sample Output
// 2
// Explanation
// None

import java.util.*;
public class Main {
	
    static int arr[] = {1, 2};

	 static int countWays(int N)
    {
        int count[] = new int[N + 1];
         
        // base case
        count[0] = 1;
         
        for (int i = 1; i <= N; i++)
            for (int j = 0; j < arr.length; j++)
     
            
                if (i >= arr[j])
                    count[i] += count[i - arr[j]];
         
        // required number of ways
        return count[N];
         
    }
     
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 System.out.println(countWays(n));
    }
}
