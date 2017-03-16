import java.util.Queue;
import java.util.LinkedList;
 
/* Class to represent Tree node */
class Node {
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}
 
/* Class to print Level Order Traversal */
class Binary_Tree {
 
    Node root;
 
    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    void printLevelOrder() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
 
            /* poll() removes the present head.
            For more information on poll() visit 
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
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
    public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
        tree_level.root.right.right = new Node(6);
        tree_level.root.right.left = new Node(8);


 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
        System.out.println("Dia "+tree_level.diameter(tree_level.root));
        System.out.println("maxWidth "+tree_level.maxWidth(tree_level.root));

    }
}