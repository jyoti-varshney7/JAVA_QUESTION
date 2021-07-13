// Given an integer 'n'. Print all the possible pairs of 'n' balanced parentheses.
// The output strings should be printed in the sorted order considering '(' has higher value than ')'.

// Input Format
// Single line containing an integral value 'n'.

// Constraints
// 1<=n<=11

// Output Format
// Print the balanced parentheses strings with every possible solution on new line.

// Sample Input
// 2
// Sample Output
// ()() 
// (()) 

import java.util.*;
public class Main {
    private static void genB(String ans, int n, int oc, int cc) {
		
		if(oc == n && cc == n) {
			System.out.println(ans);
			return;
		}
		
		if(oc > cc) {
			genB(ans + ')', n, oc, cc + 1);
		}
		
		if(oc < n) {
			genB(ans + '(', n, oc + 1, cc);
		}
		
		
	}
    public static void main(String args[]) {
        Scanner scan=new Scanner(System.in);
        int tc=scan.nextInt();
        genB("", tc, 0, 0);
    }
}
