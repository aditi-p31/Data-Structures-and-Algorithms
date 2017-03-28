package Geek4geeks;

public class MergeSort {
    public void mergesort(int[] A,int[] temp,int left,int right){
        int mid;
        if(right > left){
            mid = (left+right)/2;
            mergesort(A,temp,left,mid);
            mergesort(A,temp,mid+1,right);
            merge(A,temp,left,mid+1,right);
        }
    }
    
    public void merge(int[] A, int[] temp, int left, int mid,int right){
        
    }
    public static void main(String args[]){
        
    }
}
