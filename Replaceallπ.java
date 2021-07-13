// Replace all occurrences of pi with 3.14

// Input Format
// Integer N, no of lines with one string per line

// Constraints
// 0 < N < 1000
// 0 <= len(str) < 1000

// Output Format
// Output result one per line

// Sample Input
// 3
// xpix
// xabpixx3.15x
// xpipippixx
// Sample Output
// x3.14x
// xab3.14xx3.15x
// x3.143.14p3.14xx
// Explanation
// // All occurrences of pi have been replaced with "3.14".


import java.util.*;
public class Main {
     public static String replacePi(String str)
    {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == 'p' && str.length() >= 2
            && str.charAt(1) == 'i') {
            return "3.14" + replacePi(str.substring(2, str.length()));
        }
        return str.charAt(0) + replacePi(str.substring(1, str.length()));
    }
    public static void main(String args[]) {
        Scanner scan=new Scanner(System.in);
        int tc=scan.nextInt();
        while(tc-->0){
            String str = scan.next();
            System.out.println(replacePi(str));
        }
    }
}
