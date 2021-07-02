class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean flag=true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                if(!valid(board,i,j,board[i][j]))flag=false;
                else continue;
            }
        }
        return flag;
    }
    public boolean valid(char[][]board,int i,int j,char k){
        for(int m=0;m<board.length;m++){
            if(m==i||m==j)continue;
           if(board[i][m]==k||board[m][j]==k)return false;
        }
        int row=i/3*3;
        int col=j/3*3;
        for(int m=row;m<row+3;m++){
            for(int n=col;n<col+3;n++){
                if(m==i||n==j)continue;
                if(board[m][n]==k)return false;
            }
        }
        return true;
        
    }
    
}