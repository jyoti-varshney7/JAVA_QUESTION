// Take as input str, a string. We are concerned with all the possible ascii-subsequences of str. E.g. “ab” has following ascii-subsequences “”, “b”, “98”, “a”, “ab”, “a98”, “97”, “97b”, “9798”

// a. Write a recursive function which returns the count of ascii-subsequences for a given string. Print the value returned.

// b. Write a recursive function which prints all possible ascii-subsequences for a given string (void is the return type for function).

// Input Format
// Enter the string

// Constraints
// None

// Output Format
// Display the number of ASCII-subsequences and display all the ASCII- subsequences

// Sample Input
// ab
// Sample Output
//  b 98 a ab a98 97 97b 9798
// 9

import java.util.*;
public class Main {
    static int count;
    static void FindSub(String str, String res,int i)
    {
        if (i == str.length()) {
            if (res.length() > 0) {
                System.out.print(res + " ");
                count++;
            }
            return;
        }
        char ch = str.charAt(i);
        FindSub(str, res, i + 1);
        FindSub(str, res + ch, i + 1);
        FindSub(str, res + (int)ch, i + 1);
        
    }
 
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String res = "";
        count =0;
        int N = str.length();
        System.out.print(" ");
        FindSub(str, res, 0);
        System.out.println();
        System.out.println(count+1);
    }
}
