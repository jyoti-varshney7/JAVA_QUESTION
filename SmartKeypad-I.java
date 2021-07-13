// You will be given a numeric string S. Print all the possible codes for S.

// Following vector contains the codes corresponding to the digits mapped.

// string table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };

// For example, string corresponding to 0 is " " and 1 is ".+@$"

// Input Format
// A single string containing numbers only.

// Constraints
// length of string <= 10

// Output Format
// All possible codes one per line in the following order.

// The letter that appears first in the code should come first

// Sample Input
// 12
// Sample Output
// .a
// .b
// .c
// +a
// +b
// +c
// @a
// @b
// @c
// $a
// $b
// $c
// Explanation
// For code 1 the corresponding string is .+@$ and abc corresponds to code 2.



import java.util.*;
public class Main {
    static String[] mapping = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {

		if (digits.length() == 0) {
			return new ArrayList<>();
		}
		
		List<String> res = new ArrayList<>();
		helper(digits, "", res);
		return res;
	}

	public static void helper(String digits, String comb, List<String> res) {

		if (digits.length() == 0) {
			res.add(comb);
			System.out.println(comb);
			return;
		}
		char digitPressed = digits.charAt(0); // '2' char
		int index = digitPressed - '0'; // int 2

		String mappedString = mapping[index];
		// System.out.println(mappedString);

		for (int i = 0; i < mappedString.length(); i++) {

			String bachiKuchiString = digits.substring(1);
			char choice = mappedString.charAt(i);
			helper(bachiKuchiString, comb + choice, res);
		}

	}
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        letterCombinations(s);
    }
}
