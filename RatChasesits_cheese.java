// You are given an N*M grid. Each cell (i,j) in the grid is either blocked, or empty. The rat can move from a position towards left, right, up or down on the grid.
// Initially rat is on the position (1,1). It wants to reach position (N,M) where it's cheese is waiting for. There exits a unique path in the grid . Find that path and help the rat reach its cheese.

// Input Format
// First line contains 2 integers N and M denoting the rows and columns in the grid.
// Next N line contains M characters each. An 'X' in position (i,j) denotes that the cell is blocked and ans 'O' denotes that the cell is empty.

// Constraints
// 1 <= N , M <= 10

// Output Format
// Print N lines, containing M integers each. A 1 at a position (i,j) denotes that the (i,j)th cell is covered in the path and a 0 denotes that the cell is not covered in the path.
// If a path does not exits then print "NO PATH FOUND"

// Sample Input
// 5 4
// OXOO
// OOOX
// XOXO
// XOOX
// XXOO
// Sample Output
// 1 0 0 0 
// 1 1 0 0 
// 0 1 0 0 
// 0 1 1 0 
// 0 0 1 1 

import java.util.*;
public class Main {

    static boolean hasPath;
	public static void printPath(char[][] maze, int cr, int cc, int er, int ec,  int[][] vis) {
		if (cr >= er || cc >= ec || cr < 0 || cc < 0 || vis[cr][cc] == 1 || maze[cr][cc] == 'X') {
			return;
		}

		if (cr == er-1 && cc == ec-1) {
			vis[cr][cc] = 1;
             for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                System.out.print(vis[i][j] + " ");
            }
            System.out.println();
        }
            hasPath = true;
			return;
		}
        

		vis[cr][cc] = 1; // topi pehnai
		printPath(maze, cr - 1, cc, er, ec,  vis);
		printPath(maze, cr + 1, cc, er, ec, vis);
		printPath(maze, cr, cc - 1, er, ec, vis);
		printPath(maze, cr, cc + 1, er, ec,  vis);
		vis[cr][cc] = 0; // topi utarna //backtracking

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char maze[][] = new char[n][m];
        for(int i=0;i<n;i++){
            String st = sc.next();
            for(int j=0;j<m;j++){
                maze[i][j] = st.charAt(j);
            }
        }

        printPath(maze , 0 , 0 ,n , m , new int[n][m]);

        if(!hasPath){
             System.out.println("NO PATH FOUND");
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(maze[i][j] + " ");
        //     }
        //     System.out.println();
        // }

    }
}
