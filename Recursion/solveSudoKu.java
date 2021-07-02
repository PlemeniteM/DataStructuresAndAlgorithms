class Solution {
    char[][] fBoard;
    public void solveSudoku(char[][] board) {
        fBoard=new char[9][9];
        fillBoard(board,0,0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=fBoard[i][j];
            }
        }

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
    public void change(char[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
          fBoard[i][j]=board[i][j];
      }
    }
  }
    public void fillBoard(char[][] board,int i,int j){
        if(i==board.length){
            change(board);
            return;
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
            fillBoard(board,ni,nj);
        }
        else{
            for(char k='1';k<='9';k++){
                if(valid(board,i,j,k)){
                    board[i][j]=k;
                    fillBoard(board,ni,nj);
                    board[i][j]='.';
                }
            }
        }
        
    }
}