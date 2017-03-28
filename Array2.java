/*Majority Element: A majority element in an array A[] of size n is an element 
that appears more than n/2 times (and hence there is at most one such element).*/

//Moore's majority voting rule


package Geek4geeks;

public class Array2 {
    public static void main(String args[]){
        int a[] = {2,2,3,3,3,4,3};
        MajorityElement(a,0);
    }
    
    public static void MajorityElement(int[] a, int index){
        int candidate = a[index];
        int count = 1,c=0;
        for(int i=1; i<a.length; i++){
            if(candidate == a[i]){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                candidate = a[i];
                count = 1;
            }
        }
        if(count > 0){
            for(int i=0;i<a.length;i++){
                if(a[i] == candidate){
                    c++;
                }
            }
            if(c > a.length/2){
                System.out.println("Majority element:" + candidate);
                return;
            }
            else{
                System.out.println("No Majority");
            }
        }
        else
        {
            System.out.println("No Majority");
            return;
        }
    }
}
