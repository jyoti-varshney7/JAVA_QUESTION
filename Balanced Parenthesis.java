// You are given a string of brackets i.e. '{', '}' , '(' , ')', '[' , ']' . You have to check whether the sequence of parenthesis is balanced or not.
// For example, "(())", "(())()" are balanced and "())(", "(()))" are not.

// Input Format
// A string of '(' , ')' , '{' , '}' and '[' , ']' .

// Constraints
// 1<=|S|<=10^5

// Output Format
// Print "Yes" if the brackets are balanced and "No" if not balanced.

// Sample Input
// (())
// Sample Output
// Yes
// Explanation
// (()) is a balanced string.


import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		//Main mainobj = new Main();
		//StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
		Stack<Character> stack = new Stack<>();
		if (isBalanced(str, stack)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean isBalanced(String str, Stack<Character> s){
			for(int i = 0; i < str.length(); i++) {
			char ci = str.charAt(i);
			
			if(ci == '[' || ci == '{' || ci == '(') {
				s.push(ci);
			} else if(ci == ')' || ci == '}' || ci == ']'){
				
				if(s.isEmpty()) {
					return false;
				} 
				
				char topCh = s.pop();
				
				if(topCh == '(' && ci == ')') {
					continue;
				} 
				
				if(topCh == '{' && ci == '}') {
					continue;
				} 
				
				if(topCh == '[' && ci == ']') {
					continue;
				}
				
				return false; 
			}
		}
		
		if(s.isEmpty()) {
			return true;
		} else {
			return false;
		}

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

