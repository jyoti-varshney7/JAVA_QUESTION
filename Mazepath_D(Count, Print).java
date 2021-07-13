// Take as input N1 and N2, both numbers. N1 and N2 is the number of rows and columns on a rectangular board. Our player starts in top-left corner of the board and must reach bottom-right corner. In one move the player can move 1 step horizontally (right) or 1 step vertically (down) or 1 step diagonally (south-east).

// a. Write a recursive function which returns the count of different ways the player can travel across the board. Print the value returned.

// b. Write a recursive function which prints moves for all valid paths across the board (void is the return type for function).

// Input Format
// Enter the number of rows N1 and number of columns N2

// Constraints
// None

// Output Format
// Display the total number of paths and print all the possible paths in a space separated manner

// Sample Input
// 3
// 3
// Sample Output
// VVHH VHVH VHHV VHD VDH HVVH HVHV HVD HHVV HDV DVH DHV DD
// 13




import java.util.*;
public class Main {
   static int count;
	public static void printPath(int cr, int cc, int er, int ec, String path) {
		if(cr > er || cc > ec) {
			
			return;
		}
		
		if(cr == er && cc == ec) {
			count++;
			System.out.print(path  + " ");
			return;
		}		
        printPath(cr + 1, cc, er, ec, path + 'V');
        printPath(cr, cc + 1, er, ec, path + 'H');
        printPath(cr+1, cc + 1, er, ec, path + 'D');
		
	}
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        count = 0;
		printPath(0, 0, n1 - 1, n2 - 1, "");
		System.out.println();
        System.out.println(count);
    }
}
