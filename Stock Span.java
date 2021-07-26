// The stock span problem is a financial problem where we have a series of N daily price quotes for a stock and we need to calculate span of stock’s price for all N days. You are given an array of length N, where ith element of array denotes the price of a stock on ith. Find the span of stock's price on ith day, for every 1<=i<=N.
// A span of a stock's price on a given day, i, is the maximum number of consecutive days before the (i+1)th day, for which stock's price on these days is less than or equal to that on the ith day.

// Input Format
// First line contains integer N denoting size of the array.
// Next line contains N space separated integers denoting the elements of the array.

// Constraints
// 1 <= N <= 10^6

// Output Format
// Display the array containing stock span values.

// Sample Input
// 5
// 30
// 35
// 40
// 38
// 35
// Sample Output
// 1 2 3 1 1 END
// Explanation
// For the given case
// for day1 stock span =1
// for day2 stock span =2 (as 35>30 so both days are included in it)
// for day3 stock span =3 (as 40>35 so 2+1=3)
// for day4 stock span =1 (as 38<40 so only that day is included)
// for day5 stock span =1 (as 35<38 so only that day is included)
// hence output is 1 2 3 1 1 END


import java.util.*;
public class Main {

	public static void main(String args[]) throws Exception {
		// Your Code Here
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		// Main mainobj = new Main();
		int[] prices=new int[N];
		for(int i=0;i<N;i++){
			prices[i]=s.nextInt();
		}
		// StacksUsingArrays stack = mainobj.new StacksUsingArrays(prices.length);
		Stack<Integer> stack = new Stack<>();
		int[] ans=StockSpanUsingStacks(prices, stack);
		for(int i=0;i<ans.length;i++){
			System.out.print(ans[i]+" ");
		}
		System.out.println("END");

	}

	public static int[] StockSpanUsingStacks(int[] prices, Stack<Integer> st) {
		int days = prices.length;
		int[] span = new int[days];
		span[0] = 1;
		
		// Stack<Integer> st = new Stack<>();
		
		st.push(0);
		
		for(int curr = 1; curr < days; curr++) {
			
			//jb tk prev greater element ni milta tb tk varna stack se break out
			while(!st.isEmpty() && prices[curr] > prices[st.peek()]) {
				st.pop();
			}
				
			span[curr] =  st.isEmpty() ?  curr + 1: curr - st.peek();
			st.push(curr);
		}
		
		return span;
	}

	// private class StacksUsingArrays {
	// 	private int[] data;
	// 	private int tos;

	// 	public static final int DEFAULT_CAPACITY = 10;

	// 	public StacksUsingArrays() throws Exception {
	// 		// TODO Auto-generated constructor stub
	// 		this(DEFAULT_CAPACITY);
	// 	}

	// 	public StacksUsingArrays(int capacity) throws Exception {
	// 		if (capacity <= 0) {
	// 			System.out.println("Invalid Capacity");
	// 		}
	// 		this.data = new int[capacity];
	// 		this.tos = -1;
	// 	}

	// 	public int size() {
	// 		return this.tos + 1;
	// 	}

	// 	public boolean isEmpty() {
	// 		if (this.size() == 0) {
	// 			return true;
	// 		} else {
	// 			return false;
	// 		}
	// 	}

	// 	public void push(int item) throws Exception {
	// 		if (this.size() == this.data.length) {
	// 			throw new Exception("Stack is Full");
	// 		}
	// 		this.tos++;
	// 		this.data[this.tos] = item;
	// 	}

	// 	public int pop() throws Exception {
	// 		if (this.size() == 0) {
	// 			throw new Exception("Stack is Empty");
	// 		}
	// 		int retVal = this.data[this.tos];
	// 		this.data[this.tos] = 0;
	// 		this.tos--;
	// 		return retVal;
	// 	}

	// 	public int top() throws Exception {
	// 		if (this.size() == 0) {
	// 			throw new Exception("Stack is Empty");
	// 		}
	// 		int retVal = this.data[this.tos];
	// 		return retVal;
	// 	}

	// 	public void display() throws Exception {
	// 		if (this.size() == 0) {
	// 			throw new Exception("Stack is Empty");
	// 		}
	// 		for (int i = this.tos; i >= 0; i--) {
	// 			System.out.println(this.data[i]);
	// 		}

	// 	}

	// }

}

