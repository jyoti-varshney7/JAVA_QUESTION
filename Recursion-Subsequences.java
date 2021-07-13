// Take as input str, a string. We are concerned with all the possible subsequences of str. E.g.

// a. Write a recursive function which returns the count of subsequences for a given string. Print the value returned.

// b. Write a recursive function which prints all possible subsequences for a “abcd” has following subsequences “”, “d”, “c”, “cd”, “b”, “bd”, “bc”, “bcd”, “a”, “ad”, “ac”, “acd”, “ab”, “abd”, “abc”, “abcd”.given string (void is the return type for function).
// Note: Use cin for input for C++

// Input Format
// Enter a string

// Constraints
// None

// Output Format
// Print all the subsequences in a space separated manner and isplay the total no. of subsequences.

// Sample Input
// abcd
// Sample Output
//  d c cd b bd bc bcd a ad ac acd ab abd abc abcd 
// 16
// Explanation
// Print all possible subsequences of the given string.


import java.util.*;
public class Main {
    static int count;

	public static int genSubs2(String input, String ans) {

		if (input.length() == 0) {
			
			System.out.print(ans+" ");
			return 1;
		}
		
		int count = 0;
		char cc = input.charAt(0); // a

		count = count + genSubs2(input.substring(1), ans);
		
		count = count + genSubs2(input.substring(1), ans + cc);

		return count;
	}
	

    public static void main(String args[]) {
        // Your Code Here
        Scanner scan=new Scanner(System.in);
        String str = scan.next();
        count = 0;
		int ct = genSubs2(str, "");
        System.out.println();

		System.out.println(ct);
    }
}
