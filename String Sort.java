// Nishant is a very naughty boy in Launchpad Batch. One day he was playing with strings, and randomly shuffled them all. Your task is to help Nishant Sort all the strings ( lexicographically ) but if a string is present completely as a prefix in another string, then string with longer length should come first. Eg bat, batman are 2 strings and the string bat is present as a prefix in Batman - then sorted order should have - Batman, bat.

// Input Format
// N(integer) followed by N strings.

// Constraints
// N<=1000

// Output Format
// N lines each containing one string.

// Sample Input
// 3
// bat
// apple
// batman
// Sample Output
// apple
// batman
// bat
// Explanation
// In mathematics, the lexicographic or lexicographical order (also known as lexical order, dictionary order, alphabetical order or lexicographic(al) product) is a generalization of the way words are alphabetically ordered based on the alphabetical order of their component letters.



import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp;
    Scanner sc = new Scanner (System.in);
    int n= sc.nextInt();
    String str [] = new String[n];
    for(int i=0;i<n;i++)
    {
    	str[i]= sc.next();
    }
    
    for(int i=0;i<n;i++)
    {
    	for(int j=i+1;j<n;j++)
    	{
            int l1 = str[i].length();
            int l2 = str[j].length();
            if(l1 != l2)
            {
                int len = Math.min(l1, l2);
                String s1 = str[i].substring(0, len);
                String s2 = str[j].substring(0, len);
                if(s1.compareTo(s2) == 0)
                {
                    if(l1 < l2)
                    {
                        temp=str[i];
                        str[i]=str[j];
                        str[j]=temp;
                    }
                    continue;
                }
            }
            if(str[i].compareTo(str[j]) > 0)
            {
                temp=str[i];
    			str[i]=str[j];
    			str[j]=temp;
            }
    	}
    }
    for(int i=0;i<n;i++)
    {
    	System.out.println(str[i]);
    }
    
	}

}
