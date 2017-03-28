//Basic Stack implementation

package Geek4geeks;

public class Stack {
    private int MaxSize;
    private int[] StackArray;
    private int top;
    
    public Stack(int s){
        MaxSize = s;
        StackArray = new int[MaxSize];
        top = -1;
    }
    
    public void push(int j){
        StackArray[++top] = j;
    }
    public int pop() {
      return StackArray[top--];
    }
    public int peek() {
       return StackArray[top];
    }
    public boolean isEmpty() {
       return (top == -1);
    }
    public boolean isFull() {
       return (top == MaxSize - 1);
    }
 
    
    public static void main(String[] args) {
       Stack theStack = new Stack(10); 
       
       theStack.push(10);
       theStack.push(20);
       theStack.push(30);
       theStack.push(40);
       theStack.push(50);
      
       while (!theStack.isEmpty()) {
            int value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
       }
       System.out.println("");
    }
}
