import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;



class Node{
	int val;
	Node left,right;
	Node(int x){
		val = x;
		left = right = null;
	}
}

class BinaryTreeNew{
	Node root;
	
	public void printLevelOrder(){
		if(root==null) return;

		Queue<Node> q = new LinkedList<>();

		q.add(root);
		while(q.size()>0){
			int size = q.size();
			for(int i=0;i<size;i++){
				Node s = q.poll();
				System.out.print(s.val+" ");
				if(s.left != null)
					q.add(s.left);
				if(s.right != null)
					q.add(s.right);
			}
			System.out.println();
		}
	}

	public void inOrderWithStack(){
		if(root==null) return;
		Stack<Node> stack = new Stack<>();
		Node temp = root;

		while(temp != null){
			stack.push(temp);
			temp = temp.left;
		}

		while(stack.size() > 0){
			temp = stack.pop();
			System.out.print(temp.val+" ");
			if(temp.right !=null){
				temp = temp.right;

				while(temp!=null){
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}


    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

	public int maxDepth(Node root){
		if(root == null) return 0;
		return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
	}

	public int sizeOfTree(Node root){
		if(root==null) return 0;
		return sizeOfTree(root.left) + 1 + sizeOfTree(root.right);
	}

	public Node mirrorTree(Node root){
		if(root==null) return null;
		Node left =  mirrorTree(root.left);
		Node right = mirrorTree(root.right);
		root.left = right;
		root.right = left;
		return root; 
	}


    public int diameter(Node root){
        if(root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max((lheight + 1 + rheight),Math.max(ldiameter,rdiameter));
    }

    public int height(Node root){
        if(root==null)return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }

    public int maxWidth(Node root){
        if(root==null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int maxWidth=0;
        int count = 0;
        while(q.size()>0){
            count = q.size();
            if(count > maxWidth) maxWidth = count;
           while(count > 0){ 
            Node s = q.poll();
            if(s.left != null) q.add(s.left);
            if(s.right != null) q.add(s.right);
            count--;
            }
      }
        return maxWidth;
    }

    public int getLevel(Node root, int data, int level){
    	if(root==null)return 0;
    	if(root.val == data) return level;

    	int downlevel = getLevel(root.left,data,level+1);
    	if(downlevel != 0)return downlevel;

    	downlevel = getLevel(root.right,data,level+1);
    	return downlevel;

    }

    public int sum(Node root){
    	if(root== null) return 0;
    	return (sum(root.left) + root.val + sum(root.right));
    }

    public boolean isSumTree(Node root){
    	if(root==null || (root.left==null && root.right == null)) return true;

    	int leftsum = sum(root.left);
    	int rightsum = sum(root.right);

    	return (root.val == leftsum + rightsum && isSumTree(root.left) && isSumTree(root.right));
    }

    void printLeftView(Node root){
	 	if(root==null) return;
	 	Queue<Node> q = new LinkedList<>();
		 q.add(root);
		 while(q.size()>0){
			 int size = q.size();
			 for(int i=0;i<size;i++){

			 	Node s = q.poll();
			 	if(i==size-1)
	 				System.out.print(s.val+" ");
			 if(s.left != null)
				 q.add(s.left);
	 			
			 if(s.right != null)
				 q.add(s.right);

				 
			 }
			}
	 }
 	
 	public Node lca(Node root, Node p, Node q){
 		if(root == null) return null;
 		if(p==root || q==root) return root;

 		Node left = lca(root.left,p,q);
 		Node right = lca(root.right,p,q);

 		if(left==null && right == null) return null;
 		if(left!=null && right != null) return root;
 		return left==null?right:left;
 	}


 	 public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
    }
	  public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
        BinaryTreeNew tree_level = new BinaryTreeNew();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
        tree_level.inOrderWithStack();
        System.out.println("Size : "+tree_level.sizeOfTree(tree_level.root));
        System.out.println("maxDepth : "+tree_level.maxDepth(tree_level.root));
        tree_level.root = tree_level.mirrorTree(tree_level.root);
        tree_level.printLevelOrder();
        System.out.println("Dia "+tree_level.diameter(tree_level.root));
        System.out.println("maxWidth "+tree_level.maxWidth(tree_level.root));
		System.out.println("isSumTree "+tree_level.isSumTree(tree_level.root));
		System.out.println("-----------");
		tree_level.printLeftView(tree_level.root);





    }
}