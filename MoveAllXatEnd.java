// Take as input str, a string. Write a recursive function which moves all ‘x’ from the string to its end.
// E.g. for “abexexdexed” return “abeedeedxxx”.
// Print the value returned

// Input Format
// Single line input containing a string

// Constraints
// Length of string <= 1000

// Output Format
// Single line displaying the string with all x's moved at the end

// Sample Input
// axbxc
// Sample Output
// abcxx
// Explanation
// All x's are moved to the end of string while the order of remaining characters remain the same.


import java.util.*;
public class Main {
    public static void removex(String s,int i, String ans,int len){
            if(i==len){
               // System.out.println(ans);
                int lenx = s.length() - ans.length();
                for(int j=0;j<lenx;j++){
                    ans += "x";
                }
                System.out.println(ans);
                return;
            }
            if(s.charAt(i) != 'x'){
                ans += Character.toString(s.charAt(i));
            }
            //System.out.println(ans);
            removex(s,i+1,ans,len);
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        //System.out.println(s.charAt(0));
        removex(s , 0 ,"",len);
    }
}
