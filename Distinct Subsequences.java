// Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

// Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).

// Input Format
// Input number of test cases The first argument of input contains a string, A. The second argument of input contains a string, B.

// Constraints
// 1<=T<=100
// 1 <= length(A), length(B) <= 100

// Output Format
// Return an integer representing the answer as described in the problem statement.

// Sample Input
// 1
// rabbbit
// rabbit
// Sample Output
// 3
// Explanation
// These are the possible removals of characters:
//     => A = "ra_bbit" 
//     => A = "rab_bit" 
//     => A = "rabb_it"

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);

        int test = cin.nextInt();
        cin.nextLine();

        for(int i=0;i<test;i++){
            String s = cin.nextLine();
            String t = cin.nextLine();

            System.out.println(distinctSubsequence(s, t));
        }
    }
    

    public static long distinctSubsequence(String s, String t) {
        long [][] dp = new long[s.length() + 1][t.length() + 1];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }
         return helper(s, t, s.length(), t.length(), dp);
    }
    public static long helper(String s, String t, int n, int m, long[][] dp ){

        if(m == 0){
            return 1;
        }        
        if(n == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        long inc = 0, exc = 0;
        if(s.charAt(n - 1) == t.charAt(m - 1)){
            inc = helper(s, t, n - 1, m - 1, dp);
        }
        exc = helper(s, t , n - 1, m, dp);

        return dp[n][m] = inc + exc;
    }

}
