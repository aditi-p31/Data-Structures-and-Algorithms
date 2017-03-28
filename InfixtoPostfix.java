/*
Infix to Postfix conversion
 */
package Geek4geeks;

public class InfixtoPostfix {
    private int MaxSize;
    private char[] StackArray;
    private int top;
    String postfix;
    
    static InfixtoPostfix theStack = new InfixtoPostfix(10); 
    
    public InfixtoPostfix(int s){
        MaxSize = s;
        StackArray = new char[MaxSize];
        top = -1;
    }
    
    public void push(char j){
        StackArray[++top] = j;
    }
    public char pop() {
      return StackArray[top--];
    }
    public char peek() {
       return StackArray[top];
    }
    public boolean isEmpty() {
       return (top == -1);
    }
    public boolean isFull() {
       return (top == MaxSize - 1);
    }
 
    public void infix_to_postfix(String str){
        
        char a[] = str.toCharArray();
        for(int i=0; i< a.length; i++){
            switch (a[i]) {
            case '+': 
            case '-':
                gotOper(a[i], 1); 
                break; 
            case '*': 
            case '/':
                gotOper(a[i], 2); 
                break; 
            case '(': 
                theStack.push(a[i]);
               break;
            case ')':  
                while (!theStack.isEmpty()) {
                    char chx = theStack.pop();
                    if (chx == '(') 
                        break; 
                    else 
                        postfix = postfix + chx; 
                }
                break;
            default: 
                postfix = postfix + a[i]; 
                break;
        }
    }
    while (!theStack.isEmpty()) {
        postfix = postfix + theStack.pop();
    }
    System.out.println(postfix);
}
 
public void gotOper(char opThis, int prec1) {
    while (!theStack.isEmpty()) {
        char opTop = theStack.pop();
        if (opTop == '(') {
            theStack.push(opTop);
            break;
        } 
        else {
            int prec2;
            if (opTop == '+' || opTop == '-')
                prec2 = 1;
            else
                prec2 = 2;
            if (prec2 < prec1) { 
               theStack.push(opTop);
               break;
            } 
            else{
                if(postfix.isEmpty()){
                    postfix = Character.toString(opTop);
                }
                else{
                    postfix = postfix + opTop;
                }
            }
        }
    }
    theStack.push(opThis);
}
    
    public static void main(String[] args) {
       theStack.infix_to_postfix("a*b+c");
    }
}