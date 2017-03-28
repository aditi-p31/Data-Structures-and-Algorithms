/*
Insert a node in BST
Find a node in BST
Find minimum
Find maximum
Delete a node in BST INCOMPLETE
Check if binary tree is BST or not
*/


package Geek4geeks;
public class BinarySearchTree {
   
    private static Node root;
    static BinarySearchTree bst = new BinarySearchTree(6);
    static Stack st = new Stack(7);
    Node head, prev = null;

    public BinarySearchTree(int data)
    {
        root = new Node(data);
    }
    
    //Insert a node in the BST
    public Node insert(Node node, int key){
        if(node == null){
            node = new Node(key);
        }
        else{
            if(key < node.getKey()){
                node.setLeft(insert(node.getLeft(),key));
            }
            else if(key > node.getKey()){
                node.setRight(insert(node.getRight(),key));
            }
        }
        return node;
    }
    
    //Find a node in BST
    public void find(Node node, int data){
        if(node == null){
            System.out.println("Node not found");
            return;
        }
        while(node != null){
            if(node.getKey() == data){
                System.out.println("Node found");
                return;
            }
            else if(node.getKey() > data){
                node = node.getLeft();
            }
            else{
                node = node.getRight();
            }
        }
        System.out.println("Node not found");
        return;
    }
    
    //Find MINIMUM in BST
    public void findMin(Node node){
        if(node == null){
            return;
        }
        else{
            if(node.getLeft() == null){
                System.out.println("Minimum element is " + node.getKey());
                return;
            }
            else{
                findMin(node.getLeft());
            }
        }
    }
    
    //Find MAXIMUM in BST
    public void findMax(Node node){
        if(node == null){
            return;
        }
        else{
            if(node.getRight() == null){
                System.out.println("Maximum element is " + node.getKey());
                return;
            }
            else{
                findMin(node.getRight());
            }
        }
    }
    
    //Inorder Traversal
    public void inorderTraversal(Node n){
        if(n != null){
            inorderTraversal(n.getLeft());
            st.push(n.getKey());
            inorderTraversal(n.getRight());
        }
    }
    
    //Check if a given binary tree is BST or not
    public void isBST(Node node){
        int[] a = new int[7];
        boolean flag = true;
                
        inorderTraversal(node);
        int prev = st.pop();
        
        while(!st.isEmpty()){
            int curr = st.pop();
            if(curr > prev){
                flag = false;
                break;
            }
            prev = curr;
        }
        if(flag){
            System.out.println("Given Binary tree is a BST");
        }
        else{
            System.out.println("Given Binary tree is not BST");
        }
    }
    
    //Binary Search Tree to DLL
    public void Bst2DLL(Node node){
        if(node == null){
            return;
        }
        Bst2DLL(node.getLeft());
        
        if(prev == null){
            head = node;
        }
        else{
            prev.setRight(node);
            node.setLeft(prev);
        }
        prev = node;
        Bst2DLL(node.getRight());
    }
    
    //Print Doubly Linked List
    public void printDLL(){
        Node node = head;
        System.out.println("Doubly linked list:");
        while(node != null){
            System.out.println(node.getKey());
            node = node.getRight();
        }
    }
    
    public static void main(String args[]){
        bst.insert(root,2);
        bst.insert(root,8);
        bst.insert(root,1);
        bst.insert(root,4);
        bst.insert(root,3);
        
        bst.find(root, 7);
        bst.findMin(root);
        bst.findMax(root);
        bst.isBST(root);
        bst.Bst2DLL(root);
        bst.printDLL();
    }
}
