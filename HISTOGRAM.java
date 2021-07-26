// Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.


// Input Format
// First line contains a single integer N, denoting the number of bars in th histogram.
// Next line contains N integers, ith of which, denotes the height of ith bar in the histogram.

// Constraints
// 1<=N<=10^6
// Height of each bar in histogram <= 10^9

// Output Format
// Output a single integer denoting the area of the required rectangle.

// Sample Input
// 5
// 1 2 3 4 5
// Sample Output
// 9
// Explanation
// The largest rectangle can be obtained of breadth=3 and length=3. Its starting index is 2 and ending index is 4 and it has a height of 3. Hence area = 3*3 = 9

import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0;i < n;i++)
		    arr[i] = s.nextInt();
		    
    		Main mainobj = new Main();
    		StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
			// Stack<Integer> st = new Stack<>();
    		System.out.println(hist(arr, stack));
		}
	

	public static long hist(int[] arr, StacksUsingArrays st) throws Exception {
		int n = arr.length;
		st.push(0); // 1 value

		int[] nse = new int[n];
		for (int curr = 1; curr < arr.length; curr++) {

			while (!st.isEmpty() && arr[st.peek()] > arr[curr]) {
				nse[st.pop()] = curr;
			}

			st.push(curr);
		}

		while (!st.isEmpty()) {
			nse[st.pop()] = n;
		}

		// for (int i = 0; i < n; i++) {
		// 	System.out.println(arr[i] + "->" + nse[i]);
		// }
		
		st = new Stack<>();

		st.push(0); // 1 value

		int[] pse = new int[n];
		
		pse[0] = -1;
		
		for(int curr = 1; curr < n; curr++) {
			
			while(!st.isEmpty() && arr[st.peek()] >= arr[curr]) {
				st.pop();
			}
			
			if(!st.isEmpty()) {
				pse[curr] = st.peek();
			} else {
				pse[curr] = -1;
			}
			
			st.push(curr);
		}
		
		// for(int i = 0; i < n; i++) {
		// 	System.out.println(arr[i] + "->" + pse[i]);
		// }
		
		int maxArea = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			int width = nse[i] - pse[i] - 1;
			int height = arr[i];
			
			int area = width * height;
			
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;

	    //Write Your Code here
	    
	}

	private class StacksUsingArrays {
		private int[] data;
		private int tos;

		public static final int DEFAULT_CAPACITY = 10;

		public StacksUsingArrays() throws Exception {
			// TODO Auto-generated constructor stub
			this(DEFAULT_CAPACITY);
		}

		public StacksUsingArrays(int capacity) throws Exception {
			if (capacity <= 0) {
				System.out.println("Invalid Capacity");
			}
			this.data = new int[capacity];
			this.tos = -1;
		}

		public int size() {
			return this.tos + 1;
		}

		public boolean isEmpty() {
			if (this.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public void push(int item) throws Exception {
			if (this.size() == this.data.length) {
				throw new Exception("Stack is Full");
			}
			this.tos++;
			this.data[this.tos] = item;
		}

		public int pop() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			this.data[this.tos] = 0;
			this.tos--;
			return retVal;
		}

		public int top() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			return retVal;
		}

		public void display() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			for (int i = this.tos; i >= 0; i--) {
				System.out.println(this.data[i]);
			}

		}

	}

}

