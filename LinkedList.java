/*
Creating
Inserting
Printing
Deleting
counting length(recursive)
counting length(iterative)
Swap nodes without swapping data    
Find loop in a linked list
Merge two sorted linked list
*/


package Geek4geeks;

public class LinkedList {
    
    Node head1;//head1 of the list1
    Node head2;
    
    static class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    //prints the linkedlist
    public void printLinkedList(){
        Node n = head2;
        while(n != null){
          System.out.print(n.data + " --> ");
          n = n.next;
        }
    }
    
    //Inserting node at the starting of linked list
    public void insert_front(int data){
        Node new_node = new Node(data);
        new_node.next = head1;
        head1 = new_node;
    }
    
    //Inserting node at the end of linkedlist
    public void insert(int data){
        Node new_node = new Node(data);
        Node n = head1;
        while(n.next != null){
            n = n.next;
        }
        n.next = new_node;
    }
    
    //Inserting node after a given node
    public void insert(Node prev_node, int new_data)
    {
        /* 1. Check if the given Node is null */
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
 
        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;
 
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }
    
    //Deleting a node
    public void delete(int key){
        Node temp = head1, prev = null;
        if(temp != null && temp.data == key){
            head1 = temp.next;
            return;
        }
        
        while(temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }
        
        if(temp == null){
            return;
        }
        prev.next = temp.next;
    }
    
    //Delete node at the given position
    public void deleteNode(int position){
        Node temp = head1;
        if(temp == null){
            return;
        }
        if(position == 0){
            head1 = temp.next;
            return;
        }
        for(int i=1; i<position-1 && temp != null; i++){
            temp = temp.next;
        }
        if(temp == null && temp.next == null){
            return;
        }
        Node current = temp.next;
        temp.next = current.next.next;
        current.next = null;
        return;
    }
    
    //Length of the linked list - Iterative
    public void length(){
        Node n = head1;
        int count = 0;
        while(n != null){
            count++;
            n = n.next;
        }
        System.out.println("Count : " + count);
    }
    
    //Length of the linked list - Recursive
    public  int length(Node n){
        if(n == null)
            return 0;
        return 1+length(n.next);
    }
    
    //Swap nodes without swapping data
    public void swap(int x, int y){
        
        // Nothing to do if x and y are same
        if (x == y) return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head1;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head1;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head1 of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head1
            head1 = currY;
 
        // If y is not head1 of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head1
            head1 = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    
    //Find a loop in LinkedList
    public  void findLoop(){
        Node slw_ptr=head1, fast_ptr=head1;
        while(slw_ptr != null && fast_ptr != null && fast_ptr.next != null){
            slw_ptr = slw_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slw_ptr == fast_ptr){
                System.out.println("Loop found");
                return;
            }
        }
        System.out.println("Loop not found");
        return;
    }
    
    //Merge two sorted linkedlist
    public void SortedMerge(LinkedList l1){
        
        Node n1=l1.head1, n2=head2;
        if(n1.data > n2.data){
            while(n1 != null){
                if(n1.data > n2.next.data){
                    n2 = n2.next;
                }
                else{
                    n2.next = n1;
                    
                }
            }
        }
        else{
            
        } 
    }
    
    public static void main(String args[]){
        LinkedList llist1 = new LinkedList();
        
        llist1.head1 = new Node(5);
        Node second = new Node(10);
        Node third = new Node(15);
        
        llist1.head1.next = second; // Link first node with the second node
        second.next = third; // Link second node with the third node
        
        LinkedList llist2 = new LinkedList();
        llist2.head2 = new Node(2);
        Node second2 = new Node(3);
        Node third2 = new Node(20);
        llist2.head2.next = second2;
        second2.next = third2;
        
        //llist1.insert_front(0);
        //llist1.insert(llist1.head1.next,5);
        //llist1.printLinkedList();
        //System.out.println("\n");
        //llist.deleteNode(3);
        //llist1.swap(1, 2);
        llist2.printLinkedList();
        System.out.println("\n");
        // System.out.println(llist.length(llist.head1));
        // llist1.findLoop();
        llist2.SortedMerge(llist1);
        llist2.printLinkedList();
        
    }
}
