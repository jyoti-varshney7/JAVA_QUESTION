// Take as input N, a number. N is the size of a snakes and ladder board (without any snakes and ladders). Take as input M, a number. M is the number of faces of the dice.

// a. Write a recursive function which returns the count of different ways the board can be traveled using the dice. Print the value returned.

// b. Write a recursive function which prints dice-values for all valid paths across the board (void is the return type for function).

// Input Format
// Enter a number N (size of the board) and number M(number of the faces of a dice)

// Constraints
// None

// Output Format
// Display the number of paths and print all the paths in a space separated manner

// Sample Input
// 3
// 3
// Sample Output
// 111 12 21 3 
// 4
// {...} Code Editor

import java.util.*;
public class Main {
   public static ArrayList<String> getboardpath(int curr, int end, int M) {
		if (curr == end) {
			ArrayList<String> baseres = new ArrayList<>();
			baseres.add("");
			return baseres;
		}
		ArrayList<String> myres = new ArrayList<>();
		for (int dice = 1; dice <= M && curr + dice <= end; dice++) {
			ArrayList<String> rr = getboardpath(curr + dice, end, M);

			for (String val : rr) {
				myres.add(dice + val);
			}

		}
		return myres;

	}

    public static void main(String args[]) {
        // Your Code Here
        Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int n = s.nextInt();
		ArrayList<String> ans = getboardpath(0, a, n);
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
		System.out.println(ans.size());
    }
}
