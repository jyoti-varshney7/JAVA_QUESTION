// Take as input str, a string. Write a recursive function which returns a new string in which all duplicate consecutive characters are separated by a ‘ * ’. E.g. for “hello” return “hel*lo”. Print the value returned

// Input Format
// Enter a String

// Constraints
// 1<= Length of string <= 10^4

// Output Format
// Display the resulting string (i.e after inserting (*) b/w all the duplicate characters)

// Sample Input
// hello
// Sample Output
// hel*lo
// Explanation
// We insert a "*" between the two consecutive 'l' .


import java.util.*;
public class Main {
    public static String inserStartAndHyphen(String s){
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(0));
    for(int i = 0; i < s.length() - 1; i++){
      char v1 = s.charAt(i);
      char v2 = s.charAt(i + 1);
      if(v1 == v2) {
        sb.append('*');
      } 
   sb.append(s.charAt(i + 1));
    }
    return sb.toString();
  }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(inserStartAndHyphen(s));
    }
}
