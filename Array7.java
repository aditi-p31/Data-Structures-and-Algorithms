/*There are two sorted arrays. First one is of size m+n containing only m elements. 
Another one is of size n and contains n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.
*/

package Geek4geeks;

import java.util.Arrays;

public class Array7 {
    public static void main(String args[]){
        int[] a = new int[5];
        int[] b = {5,8,12,14};
        int j = a.length - 1;
        
        a[0] = 2;
        for(int i=a.length-1;i>=0;i--){
            if(a[i] != 0){
                a[j] = a[i];
                a[i] = 0;
                j--;
            }
        }
        MergeArrays(a,b);
        System.out.println(Arrays.toString(a));
    }
    
    public static void MergeArrays(int[] a, int[] b){
        int j = b.length, k=0;
        for(int i=0;i<b.length;i++){
            if(j > a.length-1){
                a[k] = b[i];
                k++;
            }
            else if(a[j] < b[i]){
                a[k] = a[j];
                a[j] = 0;
                j++;
                k++;
                i--;
            }
            else if(a[j] > b[i]){
                a[k] = b[i];
                k++;
            }
        }
        return;
    }
}
