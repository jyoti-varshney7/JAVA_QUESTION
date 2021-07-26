// Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

// You have the following 3 operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
// Input Format
// Two strings

// Constraints
// None

// Output Format
// Single integer output

// Sample Input
// word1 = "horse", word2 = "ros"
// Sample Output
// 3
// Explanation
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')


import java.util.*;
public class Main {
    private static int sol(String s1, String s2, int n, int m) {
		if(n == 0 && m == 0) {
			return 0;
		}
		if(n == 0) {
			return m;
		}
		if(m == 0) {
			return n;
		}
		if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return sol(s1, s2, n - 1, m - 1);
		} 
		int ins = sol(s1, s2, n, m - 1);
		int rep = sol(s1, s2, n - 1, m - 1);
		int del = sol(s1, s2, n - 1, m);

		return 1 + Math.min(ins, Math.min(rep, del));
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println(sol(s1, s2, s1.length(), s2.length()));
	}

}
