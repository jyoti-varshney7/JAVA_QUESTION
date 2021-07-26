// We are given a circular array, print the next greater number for every element. If it is not found print -1 for that number. To find the next greater number for element Ai , start from index i + 1 and go uptil the last index after which we start looking for the greater number from the starting index of the array since array is circular.

// Input Format
// First line contains the length of the array n. Second line contains the n space separated integers.

// Constraints
// 1 <= n <= 10^6
// -10^8 <= Ai <= 10^8 , 0<= i< n

// Output Format
// Print n space separated integers each representing the next greater element.

// Sample Input
// 3
// 1 2 3
// Sample Output
// 2 3 -1
// Explanation
// Next greater element for 1 is 2,
// for 2 is 3 but not present for 3 therefore -1
import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}

		int[] nge = new int[n];

		
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		int curr = 0;
		for(curr = 1; curr < n; curr++) {
			while(!st.isEmpty() && arr[curr] > arr[st.peek()]) {
				nge[st.pop()] = arr[curr];
			}
			st.push(curr);
		}
		for(int i=0 ; i<curr-2 ; i++){
			if(arr[curr-1] < arr[i])
				nge[st.pop()] = arr[i];
		}
		while(!st.isEmpty()) {
			nge[st.pop()] = -1;
		}
		for(int i = 0; i < n; i++) {
			System.out.print(nge[i]+" ");
		}
    }
}
