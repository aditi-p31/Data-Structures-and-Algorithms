package Geek4geeks;

public class Array4 {
    public static void main(String args[]){
        int[] a = {-2, -3, -4, -1, -2, -1, -5, -3};
        MaximumSubarray(a);
    }
    
    public static void MaximumSubarray(int[] a){
        System.out.println(a);
        int cur_max = a[0], max_so_far = a[0];
        System.out.println(cur_max);
        System.out.println(max_so_far);
        for(int i=1; i<a.length; i++){
            cur_max = Integer.max(a[i], cur_max+a[i]);
            max_so_far = Integer.max(cur_max, max_so_far);
            System.out.println("Cur_max = " + cur_max);
            System.out.println("Max_so_far = " + max_so_far);
        }
        System.out.println("Maximum sum:" + max_so_far);
        return;
    }
}