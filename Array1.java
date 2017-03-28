/*Write a C program that, given an array A[] of n numbers and another number x, 
determines whether or not there exist two elements in S whose sum is exactly x. */

package Geek4geeks;

import java.util.Arrays;

public class Array1 {
    public static void main(String args[]){
        int input[] = {-8,1,4,6,10,45};
        int n = 10;
        int temp[] = new int[input.length];
        MergeSort(input, temp, 0, input.length-1);
        System.out.println(Arrays.toString(input));
        CheckSum(input, n);
    }
    
    public static void MergeSort(int[] input, int[] temp, int left, int right){
        if(left < right){
            int center = (left + right)/2;
            MergeSort(input,temp,left,center);
            MergeSort(input, temp, center+1, right);
            merge(input, temp, left, center+1, right);
        }
    }
    
    public static void merge(int[] input, int[] temp, int left, int right, int rightEnd){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(input[left] <= input[right])
                temp[k++] = input[left++];
            else
                temp[k++] = input[right++];

        while(left <= leftEnd)    // Copy rest of first half
            temp[k++] = input[left++];

        while(right <= rightEnd)  // Copy rest of right half
            temp[k++] = input[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            input[rightEnd] = temp[rightEnd];
    }
    
    public static void CheckSum(int[] input, int n){
        int i=0, j=input.length-1;
        int sum;
        while(i < j){
            sum = input[i] + input[j];
            if(sum < n){
                i++;
            }
            if(sum > n){
                j--;
            }
            if(sum == n){
                System.out.println(input[i] + " and " + input[j]);
                return;
            }                
        }
        System.out.println("Pair not found");
        return;
    }
}
