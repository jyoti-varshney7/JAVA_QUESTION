// Given preorder and inorder create the tree

// Input Format
// Enter the size of the preorder array N then add N more elements and store in the array denoting the preorder traversal of the tree. Then enter the size of the inorder array M and add M more elements and store the inorder traversal of the array.

// Constraints
// 1 <= N, M <= 10^4

// Output Format
// Display the tree using a modified preorder function. For each node , first print its left child's data , then the data of the root itself , then the data of its right child. Do this for each node in a new line in preorder manner. If one of the children does not exist print END in its place. Refer to the sample testcase.

// Sample Input
// 3
// 1 2 3
// 3
// 3 2 1
// Sample Output
// 2 => 1 <= END
// 3 => 2 <= END
// END => 3 <= END
// Explanation
// The above tree looks like

//          1
//        /
//      2
//    /
//  3

import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int[] pre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(pre, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
			Node(int data){
			    this.data = data;
			    this.left = null;
			    this.right = null;
			}
		}

		private Node root;
		private int size;

		public BinaryTree(int[] pre, int[] in) {
			this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		}

		private Node construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

			// write your code here
			if(preStart > preEnd || inStart > inEnd )
            return null;
 
        int rootValue = preorder[preStart];
        Node root = new Node(rootValue);
 
        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }
 
       
        root.left = construct(preorder, preStart+1, preStart+1-inStart+k-1, 
                          inorder, inStart, k-1 );
    
        root.right = construct(preorder, preStart+1-inStart+k, preEnd, 
                           inorder, k+1, inEnd);
 
        return root;
			
		}

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}

	}

}
