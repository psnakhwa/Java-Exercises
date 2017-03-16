//Min path sum of Binary tree

import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
		left = null;
		right = null;
	}
}

class MinPath{

	public static int minPathSum(TreeNode root){
		
		if(root==null)return 0;
		if(root.left==null && root.right==null) return root.val;

		int leftSum = Integer.MAX_VALUE;
		int rightSum = Integer.MAX_VALUE;
		int sum = 0;

		if(root.left != null) 
			leftSum = minPathSum(root.left);
		if(root.right != null) 
			rightSum = minPathSum(root.right);

		if(leftSum<rightSum) sum = root.val + leftSum;
		else sum = root.val + rightSum;

		return sum;

	}

	public static void main(String args[]){
		
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(3);
		 root.left.left = new TreeNode(4);
		 root.left.right = new TreeNode(1);
		 root.right.left = new TreeNode(5);
		 root.right.right = new TreeNode(7);

		int m = minPathSum(root);
		System.out.println(m);

	}
}

 