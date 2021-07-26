// Josh is stuck in a m*n grid. He has to travel from top left to bottom right.For every cell to pass, there is a specific amount of money josh has to pay. Your task is to find out minimum amount of money josh has to pay to reach bottom right.

// Input Format
// First line contains two space separated integers m and n i.e number of rows and columns of grid. m lines follow each containing n integers, denoting the cost of which josh has to pay to pass through that cell.

// Constraints
// None

// Output Format
// A single integer denoting minimum cost josh has to pay.

// Sample Input
// 3 3 
// 1 3 1
// 1 5 1
// 4 2 1
// Sample Output
// 7
// Explanation
// Josh will take 1→3→1→1→1 path to minimize the amount he has to pay

import java.util.*;
public class Main {
    public static int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        path[0][0] = grid[0][0];
 
        for(int i = 1; i < grid.length; i++){
           path[i][0] = path[i - 1][0] + grid[i][0]; 
        }
        for(int i = 1; i < grid[0].length; i++){
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
 
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
            }
        }
        return path[grid.length - 1][grid[0].length - 1];
    }
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
       int rows=sc.nextInt();
       int columns=sc.nextInt();
       int grid[][]=new int[rows][columns];

        for(int i=0; i<rows;i++)
         {            
            for(int j=0; j<columns;j++)
            {
                grid[i][j]=sc.nextInt();
            }
         }
         System.out.print(minPathSum(grid));
	

    }
}
