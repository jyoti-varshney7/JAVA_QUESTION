// Take as input N, a number. Write a recursive function which prints counting from 0 to N in lexicographical order. In lexicographical (dictionary) order 10, 100 and 109 will be printed before 11.

// Input Format
// Enter a number N.

// Constraints
// None

// Output Format
// Display all the numbers upto N in a lexicographical order

// Sample Input
// 10
// Sample Output
// 0 1 10 2 3 4 5 6 7 8 9 


import java.util.*;
public class Main {
    public static void lexico(int initial, int end) {
		if(initial > end) {
			return;
		}
		
		System.out.print(initial + " ");
		
		int callNumber = 0;
		
		if(initial == 0) {
			callNumber = 1;
		}
		
		while(callNumber <= 9) {
			lexico(initial * 10 + callNumber, end);
			callNumber++;
		}
	}
    public static void main(String args[]) {
        // Your Code Here
        Scanner scan=new Scanner(System.in);
        int tc=scan.nextInt();
        lexico(0, tc);
    }
}
