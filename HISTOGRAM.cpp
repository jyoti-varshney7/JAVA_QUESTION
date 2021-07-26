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

#include<iostream>
#include<stack>
using namespace std;
int main() {
	int n;
	cin>>n;
	long arr[n];
	for(int i=0;i<n;i++)
		cin>>arr[i];
	stack<int> s;
	s.push(0);
	long area=0;
	for(int i=1;i<n;i++){
		//Current element is smaller or equal:
		while(!s.empty() && arr[s.top()]>=arr[i]){
			//Pop element from stack:
			int t=s.top();
			s.pop();
			//After poping:
			//a. Stack becomes empty: all elements on it's left are larger to it:
			if(s.empty()){
				area=max(area,arr[t]*i);
			}
			//b. Stack is not empty: current top of stack is smaller to it:
			else{
				area=max(area,arr[t]*(i-s.top()-1));
			}
		}
		s.push(i);
	}
	while(!s.empty()){
		//Pop element from stack:
			int t=s.top();
			s.pop();
			//After poping:
			//a. Stack becomes empty: all elements on it's left are larger to it:
			if(s.empty()){
				//changes
				area=max(area,arr[t]*n);
			}
			//b. Stack is not empty: current top of stack is smaller to it:
			else{
				//Changes:
				area=max(area,arr[t]*(n-s.top()-1));
			}
	}
	cout<<area;
	return 0;
}
