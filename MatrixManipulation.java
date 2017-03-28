/*
print matrix in spiral way
print matix in antispiral form INCOMPLETE
skew symmetric matrix or not
*/
package Geek4geeks;

public class MatrixManipulation {
    public void spiralmatrix(int[][] a){
        int rs=0,re=a.length;
        int cs=0,ce=a[0].length;
        
        while(re != rs || ce != cs){
            int r=rs,c=cs;
            for(c=cs;c<ce;c++){
                System.out.println(a[r][c]);
            }
            c--;
            rs++;
            for(r=rs;r<re;r++){
                System.out.println(a[r][c]);
            }
            r--;
            ce--;
            for(c=ce-1;c>=cs;c--){
                System.out.println(a[r][c]);
            }
            c++;
            re--;
            for(r=re-1;r>=rs;r--){
                System.out.println(a[r][c]);
            }
            cs++;
        }
    }
    
    public void antispiral(int[][] a){
        
    }
    public static void main(String args[]){
        MatrixManipulation mm = new MatrixManipulation();
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        mm.spiralmatrix(a);
    }
}
