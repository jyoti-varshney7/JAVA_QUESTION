// Given a Binary tree, write code to create a separate array list for each level. You should return an arraylist of arraylist.

// Input Format
// Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

// Constraints
// None

// Output Format
// Display the resulting arraylist of arraylist according to given sample examples.

// Sample Input
// 50 true 12 true 18 false false true 13 false false false
// Sample Output
// [[50], [12], [18, 13]]


import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt1 = m.new BinaryTree();
		System.out.println(bt1.levelArrayList());
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

		public ArrayList<ArrayList<Integer>> levelArrayList() {

			// write your code here
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
        if(root==null) return result; 
        ArrayList<Node> list=new ArrayList<Node>();
        list.add(root);
        while(!list.isEmpty())
        {
            ArrayList<Node> Tplist=new ArrayList<Node>();
            ArrayList<Integer> level=new ArrayList<Integer>();
            while(!list.isEmpty())
            {
                Node node=list.remove(0);
                level.add(node.data);
                if(node.left!=null) Tplist.add(node.left);
                if(node.right!=null) Tplist.add(node.right);
            }
            result.add(level);
            list=Tplist; 
        }
        return result; 
		

	}

}
}
