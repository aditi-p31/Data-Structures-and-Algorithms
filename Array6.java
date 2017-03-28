package Geek4geeks;

public class Array6 {
    public static void main(String args[]){
        int[] a = {3,4,5,1,2};
        int key = 2;
        int l=0, r=a.length-1,m;
       
        while(l <= r){
            m = l + (r-l)/2;
            if(a[m] == key){
                System.out.println("Element is located at: " + m);
                break;
            }
            if(a[l] <= a[m]){
                if(key >= a[l] && key < a[m]){
                    r = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if(key > a[m] && key <= a[r]){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
        }
    }
}
