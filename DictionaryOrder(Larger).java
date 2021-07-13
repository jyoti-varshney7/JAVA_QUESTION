// Take as input str, a string. Write a recursive function which prints all the words possible by rearranging the characters of this string which are in dictionary order larger than the given string.
// The output strings must be lexicographically sorted.

// Input Format
// Single line input containing a string

// Constraints
// Length of string <= 10

// Output Format
// Display all the words which are in dictionary order larger than the string entered in a new line each. The output strings must be sorted.

// Sample Input
// cab

// Sample Output
// cba
// Explanation
// The possible permutations of string "cab" are "abc" , "acb" ,"bac" , "bca" , "cab" and "cba" . Only one of them is lexicographically greater than "cab". We only print "cba".


import java.util.*;
public class Main {
    static String val ;
    private static void sol(String inp, String ans,String str) {
		// TODO Auto-generated method stub
		if(inp.length()==0){
		if(ans.compareTo(str) != 0 && ans.compareTo(str) > 0)
			System.out.println(ans);
			return;
		}
		for(int i = 0; i < inp.length(); i++) {
			String bachiHuiString = inp.substring(0, i) + inp.substring(i + 1);
			char nikalaFixed = inp.charAt(i);
			
			sol(bachiHuiString, ans + nikalaFixed,str);
		}
	}
      
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String str1 = sc.next();
        char[] ar = str1.toCharArray();
        Arrays.sort(ar);
        String str2 = new String(ar);  
        if(str2.length()<=25)
            sol(str2, "" ,str1);
    }
}
