/*Binary Tree Implementation 
And Preorder traversal(recursive)
Inorder Traversal (recursive)
Postorder Traversal (recursive)
Preorder traversal (iterative)
Inorder Traversal (iterative)
Postorder Traversal (iterative) INCOMPLETE
Levelorder Traversal
Levelorder Traversal in reverse
Height of binary tree(recursive)
Height of binary tree(iterative)
Minimum depth of binary tree
Diameter of binary tree
Maximum width of binary tree
Maximum element in the binary tree
Number of leaves in the binary tree RECURSIVE
Number of full nodes in the binary tree RECURSIVE
Print all root-to-leaf paths
Check if a path exist with given sum
Print all the ancestors of a given node
LCA of two nodes
*/


package Geek4geeks;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class BinaryTree
{
    private static Node root;
    static BinaryTree l1=new BinaryTree(1);

    public BinaryTree(int data)
    {
        root = new Node(data);
    }

    //Adds node to the binaryt tree
    public void add(Node parent,Node child, String orientation)
    {
        if(orientation=="left")
        {
           parent.setLeft(child);
        }
        else if (orientation=="right")
        {
            parent.setRight(child);
        }

    }
    
    //Preorder Traversal
    public void preorderTraversal(Node n){
        if(n != null){
            System.out.println(n.getKey());
            preorderTraversal(n.getLeft());
            preorderTraversal(n.getRight());
        }
    }
    
    //Inorder Traversal
    public void inorderTraversal(Node n){
        if(n != null){
            inorderTraversal(n.getLeft());
            System.out.println(n.getKey());
            inorderTraversal(n.getRight());
        }
    }
    
    //Postorder Traversal
    public void postorderTraversal(Node n){
        if(n != null){
            postorderTraversal(n.getLeft());
            postorderTraversal(n.getRight());
            System.out.println(n.getKey());
        }
    }
    
    //Preorder Traversal - ITERATIVE
    public void preorderTraversal_iterative(Node n){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> myStack = new Stack<>();
        Node temp;
        if(n == null){
            System.out.println("null");
            return;
        }
        myStack.push(n);
        while(!myStack.isEmpty()){
            temp = myStack.pop();
            res.add(temp.getKey());
            if(temp.getRight() != null){
                myStack.push(temp.getRight());
            }
            if(temp.getLeft() != null){
                myStack.push(temp.getLeft());
            }
        }
        System.out.println("Preorder:" + res);
    }
    
    //Inorder Traveresal - ITERATIVE
    public void inorderTraversal_iterative(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> s = new Stack<>();
        Node current_node = root;
        boolean done = false;
        while(!done){
            if(current_node != null){
                s.push(current_node);
                current_node = current_node.getLeft();
            }
            else{
                if(s.isEmpty()){
                    done = true;
                    System.out.println("Iterative inorder" + res);
                    return;
                }
                else{
                    current_node = s.pop();
                    res.add(current_node.getKey());
                    current_node = current_node.getRight();
                }
            }
        }
        System.out.println("Iterative inorder - " + res);
    }
    
    //Postorder Traversal - ITERATIVE
    public void postorderTraversal_Iterative(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> s = new Stack<>();
        Node temp = root;
        s.push(temp);
        while(!s.isEmpty()){
            temp = s.peek();
            if(temp.getLeft() != null){
                temp = temp.getLeft();
                s.push(temp);
            }
            else if(temp.getRight() != null){
                temp = temp.getRight();
                s.push(temp);
            }
            else{
                res.add(s.pop().getKey());
            }
        }
    }
    
    //Levelorder Traversal
    public void levelorderTraversal(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        
        Node current_node = root;
        q.add(root);
        while(!q.isEmpty()){
            current_node = q.poll();
            res.add(current_node.getKey());
            if(current_node.getLeft() != null){
                q.add(current_node.getLeft());
            }
            if(current_node.getRight() != null){
                q.add(current_node.getRight());
            }
        }
        System.out.println("Level order Traversal" + res);
    }
    
    //Levelorder Traversal in reverse
    public void levelorderTraversal_reverse(){
        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> s = new Stack<>();
        
        Node current_node = root;
        q.add(root);
        while(!q.isEmpty()){
            current_node = q.poll();
            s.push(current_node);
            
            if(current_node.getRight() != null){
                q.add(current_node.getRight());
            }
            if(current_node.getLeft() != null){
                q.add(current_node.getLeft());
            }
        }
        System.out.println("Level order Traversal in Reverse");
        while(!s.isEmpty()){
            System.out.println(s.pop().getKey());
        }
        
    }
    
    //Height of binary tree - RECURSIVE
    public int height_binarytree_recursive(Node n){
        
        if(n == null){
            return 0;
        }
        int height_leftsubtree = height_binarytree_recursive(n.getLeft());
        int height_rightsubtree = height_binarytree_recursive(n.getRight());
        return (Math.max(height_leftsubtree, height_rightsubtree)+1);
    }
    
    //Height of binary tree - ITERATIVE
    public void height_binarytree_iterative(){
        Queue<Node> q = new LinkedList<>();
        Node current_node = root;
        int count = 1;
        
        q.add(current_node);
        q.add(null);
        while(!q.isEmpty()){
            current_node = q.poll();
            if(current_node != null){
                /*if(current_node.getLeft() == null || current_node.getRight() == null){
                    System.out.println("Height of binary tree:" + count);
                    return;
                }*/
                if(current_node.getLeft() != null){
                    q.offer(current_node.getLeft());
                }
                if(current_node.getRight() != null){
                    q.offer(current_node.getRight());
                }
            }
            else{
                if(!q.isEmpty()){
                    count++;
                    q.offer(null);
                }
            }
        }
        System.out.println("Height of binary tree: " + count);
    }
    
    //Minimum depth of binary tree
    public void minimumdepth_binarytree(){
        Queue<Node> q = new LinkedList<>();
        Node current_node = root;
        int count = 1;
        
        q.add(current_node);
        q.add(null);
        while(!q.isEmpty()){
            current_node = q.poll();
            if(current_node != null){
                if(current_node.getLeft() == null || current_node.getRight() == null){
                    System.out.println("Minimum Depth of binary tree:" + count);
                    return;
                }
                if(current_node.getLeft() != null){
                    q.offer(current_node.getLeft());
                }
                if(current_node.getRight() != null){
                    q.offer(current_node.getRight());
                }
            }
            else{
                if(!q.isEmpty()){
                    count++;
                    q.offer(null);
                }
            }
        }
        System.out.println("Minimum Depth of binary tree: " + count);
    }
    
    
    //Width of the binary tree
    public void width(){
        Queue<Node> q = new LinkedList<>();
        Node current_node = root,temp = null;
        int count = 0, max=0;
        
        q.add(current_node);
        q.add(null);
        while(!q.isEmpty()){
            current_node = q.poll();
            count++;
            if(current_node != null){
                if(current_node.getLeft() != null){
                    q.offer(current_node.getLeft());
                }
                if(current_node.getRight() != null){
                    q.offer(current_node.getRight());
                }
            }
            else{
                if(!q.isEmpty()){
                    if(count >= max){
                        max = count;
                    }
                    count = 0;
                    q.offer(null);
                }
            }
        }
        System.out.println("Width of binary tree: " + count);
    }
    
    
    
    public int diameter(Node n){
        int count = 0;
        if(n == null){
            return 0;
        }
        int left_height = l1.height_binarytree_recursive(n.getLeft());
        int right_height = l1.height_binarytree_recursive(n.getRight());
        int len1 = left_height + right_height + 1;
        
        int len2 = Math.max(diameter(n.getLeft()), diameter(n.getRight()));
        
        return(Math.max(len1, len2));
    }
    
    //Maximum element in the binary tree
    public int findMax(Node node,int maxValue){
        if(node == null)
        {
            return maxValue;
        }
        if(node.getKey() > maxValue){
            maxValue = node.getKey();
        }
        maxValue = findMax(node.getLeft(), maxValue);
        maxValue = findMax(node.getRight(), maxValue);
        return maxValue;
    }
    
    //Number of leaves in the binary tree - RECURSIVE
    public int NumberofLeaves(Node node){
        
        if(node == null){
            return 0;
        }
        if(node.getLeft() == null && node.getRight() == null){
            return 1;
        }
        return NumberofLeaves(node.getLeft()) + NumberofLeaves(node.getRight());
    }
    
    //Number of Full nodes in the binary tree
    public int FullNodes(Node node){
        if(node == null){
            return 0;
        }
        if(node.getLeft() != null && node.getRight() != null){
            return 1 + FullNodes(node.getLeft()) + FullNodes(node.getRight());
        }
        return FullNodes(node.getLeft()) + FullNodes(node.getRight());
    }    
    
    //Print all the root-to-leaf paths
    public void printPath(Node node, int[] path, int pathlen){
        if(root == null){
            return;
        }
        path[pathlen] = node.getKey();
        pathlen++;
        
        if(node.getLeft() == null && node.getRight() == null){
            printArray(path, pathlen);
        }
        else{
            printPath(node.getLeft(), path, pathlen);
            printPath(node.getRight(), path, pathlen);
        }
    }
    
    //Function to print array
    public void printArray(int[] path, int pathlen){
        for(int i=0;i<pathlen;i++){
            System.out.print(path[i] + " ");
        }
        System.out.println("\n");
    }
    
    //Check if there exist a path from root to some node with the given sum
    public boolean hasPathSum(Node node, int sum){
        if(node == null){
            return false;
        }
        if(sum == node.getKey()){
            return true;
        }
        else{
            return hasPathSum(node.getLeft(),sum - node.getKey()) || hasPathSum(node.getRight(),sum - node.getKey());
        }
    }
    
    //Print all the ancestors of a given node
    public boolean printAncestors(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.getKey() == data){
            return true;
        }
        if(printAncestors(node.getLeft(),data) || printAncestors(node.getRight(), data)){
            System.out.println(node.getKey());
            return true;
        }
        return false;
    }
    
    //Least Common Ancestor(LCA) of two nodes
    public Node LCA(Node root_node, Node a, Node b){
        if(root_node == null){
            return root_node;
        }
        if(root_node == a || root_node == b)
        {
            return root_node;
        }
        Node left = LCA(root_node.getLeft(),a,b);
        Node right = LCA(root_node.getRight(),a,b);
        
        if(left != null && right !=null){
            return root_node;
        }
        else{
            return(left != null?left:right);
        }
    }
    
    public static void main(String ar[])
    {
        Node n1=new Node(20);
        Node n2=new Node(15);
        Node n3=new Node(9);
        Node n4=new Node(7);
        Node n5=new Node(6);
        Node n6=new Node(3);

        
        l1.add(root,n1,"left");
        l1.add(root,n2,"right");
        l1.add(n1,n3,"left");
        l1.add(n1,n4,"right");
        l1.add(n2, n5, "left");
        l1.add(n2, n6, "right");
        System.out.println("Preorder Traversal");
        l1.preorderTraversal(root);
        System.out.println("Inorder Traveresal");
        l1.inorderTraversal(root);
        System.out.println("Postorder Traversal");
        l1.postorderTraversal(root);
        
        l1.preorderTraversal_iterative(root);
        l1.inorderTraversal_iterative();
        l1.levelorderTraversal();
        l1.levelorderTraversal_reverse();
        System.out.println("Height of binary tree: " + l1.height_binarytree_recursive(root));
        l1.height_binarytree_iterative();
        l1.minimumdepth_binarytree();
      //  l1.delete_node(3);
      System.out.println("Diameter of binary tree: " + l1.diameter(root));
      l1.width();
        System.out.println("Maximum element is " + l1.findMax(root, 0));
        System.out.println("Number of full nodes is " + l1.FullNodes(root));
        int[] path = new int[256];
        l1.printPath(root, path, 0);
        System.out.println("Path with given sum : " + l1.hasPathSum(root, 39));
        boolean temp = l1.printAncestors(root, 7);
        System.out.println("LCA of 9 and 3 is " + l1.LCA(root, n3, n6).getKey());
    }
}

class Node {
    private int key;
    private Node left;
    private Node right;
    Node (int key) {
        this.key = key;
        right = null;
        left = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right ) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

}
