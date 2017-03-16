import java.util.*;

class BST{
	Node root;
	class Node{
		int val;
		Node left,right;
		Node(int x){
			val = x;
			left = right = null;
		}
	}

	// Insert, Search, Delete
	// Print Inorder, Preorder, Postorder
	public void insert(int key){
		root = insertRec(root,key);
	}

	public Node insertRec(Node root,int key){
		Node node = new Node(key);

		if(root==null)
			 root = node;

		if(root.val > key)
			root.left = insertRec(root.left,key);

		else if (root.val <key)
			root.right = insertRec(root.right,key);

		return root;
		
	}

	public void delete(int key){
		root = deleteRec(root,key);
	}

	public Node deleteRec(Node root, int key){
		if(root == null) return null;
		if(root.val>key)
			root.left = deleteRec(root.left,key);
		else if(root.val<key)
			root.right = deleteRec(root.right,key);
		else {
			if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else{
				root.val = getMinVal(root.right);
				root.right = deleteRec(root.right,root.val);
			}
		}
		return root;
	}

	public int getMinVal(Node root){
		
		Node curr = root;
		while(curr.left != null)
			curr = curr.left;
		return curr.val;
	}

	public Node search(Node root,int key){
		if(root==null) return null;
		if(root.val == key) return root;
		if(root.val>key) 
			return search(root.left,key);
		else 
			return search(root.right,key);
	}

	// Traversals.

	public void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.val+" ");
			inOrder(root.right);
		}
	}

	public void preOrder(Node root){
		if(root != null){
			System.out.print(root.val+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder(Node root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val+" ");
		}
	}

	public void findPreSuc(Node root, Node pre, Node suc, int key){
		if(root == null) return;
		if(root.val == key){
			if(root.left != null){
				Node temp = root.left;
				while(temp.right != null)
					temp = temp.right;

				System.out.println("pre :"+temp.val);
			}
			if(root.right != null){
				Node temp = root.right;
				while(temp.left != null)
					temp = temp.left;
				System.out.println("suc :"+temp.val);
			}
			return;
		}
			if(root.val<key){
				pre = root;
				findPreSuc(root.right,pre,suc,key);
			}
			else if(root.val>key){
				suc = root;
				findPreSuc(root.left,pre,suc,key);
			}
		
	}

	public boolean isBST(){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public boolean isBST(Node root, int min, int max){
		if(root == null) return true;
		if(root.val<min || root.val>max) return false;
		return isBST(root.left,min,root.val-1) && isBST(root.right,root.val+1,max);
	}

	public Node getMinValNode(Node root){
		Node curr = root;
		while(curr.left != null)
			curr = curr.left;
		return curr;
	}
	
	public Node inOrderSuc(Node root,Node p){
		Node res = null;
        while(root != null){
            if(root.val>p.val){
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;


	}

	public Node lca(Node root, int a, int b){
		while(root != null){
			if(root.val < a && root.val < b)
				root = root.right;
			else if(root.val>a && root.val > b)
				root = root.left;
			else break;
		}
		return root;
	}

	public Node lcaRec(Node root, int x , int y){
		if (root == null) return null;
		if(root.val<x && root.val < y) return lcaRec(root.right,x,y);
		else if(root.val > x && root.val > y) return lcaRec(root.left,x,y);
		return root;
	}

	public static void main(String[] args) {
		BST b = new BST();
		b.insert(3);
		b.insert(1);
		b.insert(10);
		b.insert(4);
		b.insert(5);
		b.inOrder(b.root);	
		System.out.println();
		b.preOrder(b.root);
		System.out.println();
		b.postOrder(b.root);
		System.out.println();
		//b.delete(1);
		b.inOrder(b.root);
		Node pre = null;
		Node suc = null;
		b.findPreSuc(b.root,pre,suc,10);
		boolean i = b.isBST();
		System.out.println("isBST : "+i);
		System.out.println("-----------------");
		Node in = b.inOrderSuc(b.root,5,null);
		System.out.println("Succ:"+in.val);
		Node temp1 = b.lcaRec(b.root,4,5);
		Node temp2 = b.lca(b.root,4,5);
		System.out.println(temp1.val+" "+temp2.val);

	}
}