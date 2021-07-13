// In a mathematics class, Teacher ask Alice to find the number of all n digit distinct integers which is formed by the two distinct digits ai and bi but there is a rule to form n digit integer.

// Rule: She has to form n digit integer by using two digits ai and bi without consecutive bi.

// Alice is very weak in maths section. Help her to find the number of such n digit integers.

// Input Format
// The first line contains T, the number of test cases. Further T lines contains the value n which is the number of digit in the integer.

// Constraints
// 1<=T<=20
// 1<=n<=25

// Output Format
// For each test case print the number of such n digit integer.

// Sample Input
// 3
// 1
// 2
// 3
// Sample Output
// #1 : 2
// #2 : 3
// #3 : 5
// Explanation
// For n=1 : integers = a, b . For n=2 : integers = aa, ab, ba For n=3 : integers = aaa, aab, aba, baa, bab

import java.util.*;
public class Main {
    static int count=0;
public static void classAssignment(int n,String ans){
if(ans.length()==n){
count++;
return;
}
classAssignment(n,ans+"a");
if(ans.length()==0 || ans.charAt(ans.length()-1)!='b'){
classAssignment(n,ans+"b");
}
}
public static void main(String args[]) {
Scanner scan=new Scanner(System.in);
while(scan.hasNextInt()){
int tc=scan.nextInt();
for(int i=1;i<tc+1;i++){
int n=scan.nextInt();
classAssignment(n,"");
System.out.println("#"+i+" : "+count);
count=0;
}
}
}
}
