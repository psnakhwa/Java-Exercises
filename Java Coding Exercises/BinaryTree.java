//check if tree is balanced in java


import java.util.*;


class Node{
		int val;
		Node left,right;

		Node(int data){
			val = data;
			left = right = null;
		}
	}
class BinaryTree{

	Node root;

	boolean isBalanced(Node root){
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	int checkHeight(Node root){
		if (root == null) return -1;

		int lheight = checkHeight(root.left);
		if (lheight==Integer.MIN_VALUE)	return Integer.MIN_VALUE;

		int rheight = checkHeight(root.right);
		if (rheight==Integer.MIN_VALUE) return Integer.MIN_VALUE;

		int heightDiff = lheight - rheight;
		if (Math.abs(heightDiff) > 1) return Integer.MIN_VALUE;
		else return Math.max(lheight,rheight) + 1;
	}

	 public static void main(String args[])
    {
         /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
 
        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
	
}