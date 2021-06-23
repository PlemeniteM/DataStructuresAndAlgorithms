class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image,sr,sc,newColor,image[sr][sc]);
        
        return image;
    }
    public void helper(int[][] maze,int sr,int sc,int ncol,int oc){
        if(sr<0||sc<0||sr>=maze.length||sc>=maze[0].length||maze[sr][sc]==ncol||maze[sr][sc]!=oc){return;}

        maze[sr][sc]=ncol;
         
        helper(maze,sr+1,sc,ncol,oc);
        helper(maze,sr,sc-1,ncol,oc);
        helper(maze,sr-1,sc,ncol,oc);
        helper(maze,sr,sc+1,ncol,oc);
    }
}