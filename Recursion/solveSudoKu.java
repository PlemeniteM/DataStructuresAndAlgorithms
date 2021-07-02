class Solution {
    public void solveSudoku(char[][] board) {
        fillBoard(board,0,0);
    }
    public boolean valid(char[][]board,int i,int j,char k){
        for(int m=0;m<board.length;m++){
           if(board[i][m]==k||board[m][j]==k)return false;
        }
        int row=i/3*3;
        int col=j/3*3;
        for(int m=row;m<row+3;m++){
            for(int n=col;n<col+3;n++){
                if(board[m][n]==k)return false;
            }
        }
        return true;
        
    }
    public boolean fillBoard(char[][] board,int i,int j){
        if(i==board.length){
           return true;
        }
        int ni=0;
        int nj=0;
        if(j==board.length-1){
            ni=i+1;
            nj=0;
        }
        else{
            ni=i;
            nj=j+1;
        }
        if(board[i][j]!='.'){
            if(fillBoard(board,ni,nj))return true;//if suduko gets solved then no further permutations are neccessary
        }
        else{
            for(char k='1';k<='9';k++){
                if(valid(board,i,j,k)){
                    board[i][j]=k;
                    if(fillBoard(board,ni,nj))return true;//This is done to prevent it from checking all further possiblities if sudoku gets solved
                    board[i][j]='.';
                }
            }
        }
        return false;
        
    }
}