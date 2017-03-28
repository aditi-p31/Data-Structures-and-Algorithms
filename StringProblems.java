/*
Naive Pattern Searching
KMP Pattern Searching
Robin Karp Pattern Searching INCOMPLETE
Find all the permutations of a string
pattern matching in 2D array of characters
 */
package Geek4geeks;

public class StringProblems {
    
    //arrays for direction in search2D function
    int[] x = {-1,-1,-1,0,0,1,1,1};
    int[] y = {-1,0,1,-1,1,-1,0,1};
    
    // Naive pattern searching algorithm
    // Complexity = O(m*(n-(m-1))
    public void naive_patternsearching(String text, String pattern){
        char[] text_char = text.toCharArray();
        char[] pattern_char = pattern.toCharArray();
        int text_length = text_char.length;
        int pattern_length = pattern_char.length;
        
        for(int i=0; i<=text_length-pattern_length; i++){
            for(int j=0; j<pattern_length;j++){
                if(text_char[i+j] != pattern_char[j]){
                    break;
                }
                if(j == pattern_length-1){
                    System.out.println("Match found at index: " + i);
                }
            }
        }
    }
    
    //KMP Pattern Searching algorithm
    //Time complexity = O(m+n) and Space complexity = O(m)
    public void kmp_patternsearching(String text, String pattern){
        char[] text_char = text.toCharArray();
        char[] pattern_char = pattern.toCharArray();
        int text_length = text_char.length;
        int pattern_length = pattern_char.length;
        int[] lps = new int[pattern_length];     // create lps[] that will hold the longest prefix suffix values for pattern
        int i=0,j=0;
        
        compute_lps(pattern_char,pattern_length,lps);
        
        while(i < text_length){
            if(text_char[i] == pattern_char[j]){
                i++;
                j++;
            }
            if(j == pattern_length){
                System.out.println("Pattern match found at: " + (i-j));
                j = lps[j-1];
            }
            else if(i < text_length && text_char[i] != pattern_char[j]){
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
    }
    
    public void compute_lps(char pattern[], int pattern_length, int lps[]){
        int j=0,i=1;
        lps[0]=0;
        while(i < pattern_length){
            if(pattern[j] == pattern[i]){
                j++;
                lps[i] = j;
                i++;
            }
            else{
                if(j != 0){
                    
                    j = lps[j-1];
                }
                else{
                    lps[i] = j;
                    i++;
                }
            }
        }
    }
    
    //Robin-Karp Pattern Searching
    //Time Complexity - O(mn)
    
    //Print all the Permutations of the string
    public void permute(String str, int sind, int eind){
        if(sind == eind){
            System.out.println(str);
        }
        else{
            for(int i=sind; i<=eind ; i++){
                str = swap(str,sind,i);
                permute(str,sind+1,eind);
                str = swap(str,sind,i);
            }
        }
    }
    
    //Swap the characters
    public String swap(String str, int i, int j){
        char temp;
        char[] str_arr = str.toCharArray();
        temp = str_arr[i];
        str_arr[i] = str_arr[j];
        str_arr[j] = temp;
        return String.valueOf(str_arr);
    }
    
    public boolean findmatch(char[][] text, String pattern){
        int row_length = text.length;
        int column_length = text[0].length;
        char word[] = pattern.toCharArray();
        for(int r=0;r<row_length;r++){
            for(int c=0;c<column_length;c++){
                System.out.println(text[r][c]);
                if(search2D(text,r,c,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search2D(char[][] text, int row, int column, char[] word){
        if(text[row][column] != word[0]){
            return false;
        }
        int len = word.length;
        int k,rd,cd;
        //Search word in all the 8 directions
        /*for(int dir=0;dir<8;dir++){
            rd = row+x[dir]; cd = column+y[dir];
            //k=1 because first string is matched
            for(k=1;k<len;k++){
                if(rd >= text.length || rd < 0 || cd >= text[0].length || cd < 0){
                    break;
                }
                
                
                if(text[rd][cd] != word[k]){
                    break;
                }
                else{
                    rd = rd + x[dir]; cd = cd + y[dir];
                }
                
            }
         
            //if all tha characters matched value will be equal to length of word
            if(k == len){
                return true;
            }
        }*/
        
        for(k=1;k<len;k++){
            for(int dir=0;dir<8;dir++){
                rd = row+x[dir]; cd = column+y[dir];
                if(rd >= text.length || rd < 0 || cd >= text[0].length || cd < 0){
                    continue;
                }
                
                System.out.println("Searching - " + text[rd][cd]);
                if(text[rd][cd] != word[k]){
                    continue;
                }
                
                else{
                    System.out.println("Matched");
                    row = rd + x[dir]; column = cd + y[dir];
                    break;
                }
            }
             //if all tha characters matched value will be equal to length of word
            if(k == len){
                return true;
            }
        }
        return false;
    }
    
    /*public boolean findmatch_wrapper(char[][] text, String pat){
        int r_length = text.length;
        int c_length = text[0].length;
        if(pat.length() > r_length*c_length){
            return false;
        }
        int used[][] = new int[r_length][c_length];
        char pattern[] =  pat.toCharArray();
        return findmatch(text,pattern,pattern.length,r_length,c_length,used,0,0,0);
    }
    
    public boolean findmatch(char[][] text, char[] pattern, int pattern_length,int row, int column, int[][]used, int x, int y, int level){
        System.out.println("text" + text[x][y]);
        System.out.println(x);
        System.out.println(y);
        if(pattern_length == level){
            System.out.println("1........");
            return true;
        }
        if(row == x || column == y){
            
            System.out.println("2........");
            return false;
        }
        if(used[x][y] == 1){
            
            System.out.println("3........");
            return false;
        } 
        if(text[x][y] != pattern[level] && level == 0){
            if(y < column-1){
                findmatch(text,pattern,pattern_length,row,column,used,x,y+1,level);                
            }
            else if(x < row-1){
                findmatch(text,pattern,pattern_length,row,column,used,x+1,y,level);
            }
            else{
                
            System.out.println("4........");
                return false;
            }
        }
        else if(text[x][y] == pattern[level]){
            boolean result;
            used[x][y] = 1;
            result = ((x>0)?findmatch(text,pattern,pattern_length,row,column,used,x-1,y,level+1):false||
                    (x<row-1)?findmatch(text,pattern,pattern_length,row,column,used,x+1,y,level+1):false||
                    (y>0)?findmatch(text,pattern,pattern_length,row,column,used,x,y-1,level+1):false||
                    (y<column-1)?findmatch(text,pattern,pattern_length,row,column,used,x,y+1,level+1):false||
                    (x>0 && y>0)?findmatch(text,pattern,pattern_length,row,column,used,x-1,y-1,level+1):false||
                    (x<row-1 && y<column-1)?findmatch(text,pattern,pattern_length,row,column,used,x+1,y+1,level+1):false||
                    (x>0 && y<column-1)?findmatch(text,pattern,pattern_length,row,column,used,x-1,y+1,level+1):false||
                    (x<row-1 && y>0)?findmatch(text,pattern,pattern_length,row,column,used,x+1,y-1,level+1):false);
            used[x][y] = 0;
            
            System.out.println("5........");
            return result;
        }
        else{
            
            System.out.println("6........");
            return false;
        }
        return false;
    }
    */
    public static void main(String args[]){
        StringProblems spm = new StringProblems();
        
        spm.naive_patternsearching("aabaacaadaabaaba", "aaba");
        spm.kmp_patternsearching("abxabcabcaby", "abcaby");
        String str = "abcd";
        System.out.println("Permutations of string:");
        spm.permute(str, 0, str.length()-1);
        
        System.out.println("Find pattern in 2D array");
        char[][] a = {{'a','c','p','r','c'},{'x','s','o','p','c'},{'v','o','v','n','i'},{'w','g','f','m','n'},{'q','a','t','i','t'}};
        
        boolean ans = spm.findmatch(a,"microsoft");
        System.out.println(ans);
        if(ans){
            System.out.println("Pattern found");
        }
        else{
            System.out.println("Pattern not found");
        }
    }
}
