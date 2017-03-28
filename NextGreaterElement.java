/*Program to find the next greater element for every element and return -1 if there is no next greater element*/

package Geek4geeks;

public class NextGreaterElement {
    public static void main(String args[]){
        Stack myStack = new Stack(4);
        
        int[] arr = {13,7,6,12};
        int element, next;
        
        //push the first element in the stack
        myStack.push(arr[0]);
        
        //iterate for rest of the element
        for(int i=1;i<arr.length;i++){
            
            next = arr[i];
            if(!myStack.isEmpty()){
                //if stack is not empty pop the first element
                element = myStack.pop();
                
                /*If the popped element is smaller than next, then
                a) print the pair
                b) keep popping while elements are smaller and
                   stack is not empty */
                while(element < next){
                    System.out.println(element + " --> " + next);
                    if(myStack.isEmpty()){
                        break;
                    }
                    element = myStack.pop();
                }
                /*If element is greater than next, then push
               the element back*/
                if(element > next){
                        myStack.push(element);
                }
            }
            //put next element in the stack so that we can find next greater
            myStack.push(next);
        }
        
        /*After iterating over the loop, the remaining
            elements in stack do not have the next greater
            element, so print -1 for them*/
        while(!myStack.isEmpty()){
            element = myStack.pop();
            System.out.println(element + "--> -1");
        }
    }
}
