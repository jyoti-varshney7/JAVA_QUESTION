// Given K painters to paint N boards where each painter takes 1 unit of time to paint 1 unit of boards i.e. if the length of a particular board is 5, it will take 5 units of time to paint the board. Compute the minimum amount of time to paint all the boards.

// Note that:

// Every painter can paint only contiguous segments of boards.
// A board can only be painted by 1 painter at maximum.
// Input Format
// First line contains K which is the number of painters. Second line contains N which indicates the number of boards. Third line contains N space separated integers representing the length of each board.

// Constraints
// 1 <= K <= 10
// 1 <= N <= 10
// 1<= Length of each Board <= 10^8

// Output Format
// Output the minimum time required to paint the board.

// Sample Input
// 2
// 2
// 1 10
// Sample Output
// 10


import java.util.*;
public class Main {
    public static boolean canPaint(int noPainter, ArrayList<Integer> list, int mid){
        int currPainter=1;
        int time=0;
        int currBoard=0;
        while(currBoard < list.size()){
            if(time + list.get(currBoard) <= mid){
                time += list.get(currBoard);
                currBoard++;
            }
            else{
                currPainter++;
                time=0;
            }
            if(currPainter > noPainter){
                return false;
            }
        }
        return true;
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();//no of painter
        int b=sc.nextInt();//no of board
        ArrayList<Integer> list=new ArrayList<>();
        int sum=0;
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            list.add(num);
            sum+=num;
        }
        int l=0;
        int r=sum;
        while(r>l+1){
            int mid=(l+r)/2;
            if(canPaint(a, list, mid)){
                r=mid;
            }
            else{
                l=mid;
            }
        }
        System.out.println(r);
    }
}
