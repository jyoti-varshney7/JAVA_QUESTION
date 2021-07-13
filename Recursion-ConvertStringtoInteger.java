// Take as input str, a number in form of a string. Write a recursive function to convert the number in string form to number in integer form. E.g. for “1234” return 1234. Print the value returned.

// Input Format
// Enter a number in form of a String

// Constraints
// 1 <= Length of String <= 10

// Output Format
// Print the number after converting it into integer

// Sample Input
// 1234
// Sample Output
// 1234
// Explanation
// Convert the string to int. Do not use any inbuilt functions.

import java.util.*;
public class Main {
    public static void StringtoInt(String s, int ans,int i) {
        if(i == s.length()){
           System.out.println(ans);
           return;
        }
        int val = Integer.parseInt(Character.toString(s.charAt(i)));
        //System.out.println(val);
        ans = ans*10 + val;
        StringtoInt(s,ans,i+1);
        return ;
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc =new Scanner(System.in);
        String s = sc.next();
        //System.out.println(Integer.parseInt(Character.toString(s.charAt(0))));
        StringtoInt(s,0,0); 
    }
}
