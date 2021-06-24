class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        String r="";
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                chess[i][j]='.';
            }
        helper(ans,0,chess);
        // helper(ans,0,chess,new boolean[n],new boolean[2*n-1],new boolean[2*n-1]);
        return ans;
    }
    // public void helper(List<List<String>> ans,int row,char[][] chess,boolean[] cols,boolean[] d1,boolean[] d2){
    //     if(row==chess.length){
    //         ans.add(fill(chess));
    //         return;
    //     }
    //     for(int i=0;i<chess[0].length;i++){
    //         if(!cols[i]&&!d1[row+i]&&!d2[chess.length-1+row-i]){
    //             cols[i]=true;
    //             d1[row+i]=true;
    //             d2[chess.length-1+row-i]=true;
    //             chess[row][i]='Q';
    //             helper(ans,row+1,chess,cols,d1,d2);
    //             chess[row][i]='.';
    //             cols[i]=false;
    //             d1[row+i]=false;
    //             d2[chess.length-1+row-i]=false;
    //         }
    //     }
    // }
    public void helper(List<List<String>> ans,int row,char[][] chess){
        if(row==chess.length){
            ans.add(fill(chess));
            return;
        }
        for(int i=0;i<chess[0].length;i++){
            if(isValid(chess,row,i)){
                chess[row][i]='Q';
                helper(ans,row+1,chess);
                chess[row][i]='.';
            }
        }
    }
    public boolean isValid(char[][] chess,int row, int col){
        for(int i=0;i<row;i++){
            if(chess[i][col]=='Q')return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<chess[0].length;i--,j++){
            if(chess[i][j]=='Q')return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chess[i][j]=='Q')return false;
        }
        return true;
    }
    public List<String> fill(char[][] chess){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<chess.length;i++){
            String row="";
            for(int j=0;j<chess.length;j++){
                row+=chess[i][j];
            }
            temp.add(row);
        }
        return temp;
    }
}