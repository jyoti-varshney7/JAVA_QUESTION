// Given a binary tree print all nodes that don’t have a sibling

// Input Format
// Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

// Constraints
// None

// Output Format
// Display all the nodes which do not havimport java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		bt.sibling();
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public void sibling() {
			this.sibling(this.root);
		}

		private void sibling(Node node) {
		    
		if(node == null){
		    return;
		}    
		if(node.left!= null && node.right==null){
		    System.out.print(node.left.data+" ");
		}
		else if(node.left==null && node.right!=null){
		    System.out.print(node.right.data+" ");
		}
		sibling(node.left);
		sibling(node.right);
		}

	}

}e a sibling in a space separated manner

// Sample Input
// 50 true 12 true 18 false false false false
// Sample Output
// 12 18

