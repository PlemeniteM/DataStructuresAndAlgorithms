class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        if(root==null)return -1;
        
        int[] temp=helper(root);
        
        return max;
    }
    private int[] helper(TreeNode root){
        if(root==null)return new int[]{-1,-1};
        
        int[] left=helper(root.left), right=helper(root.right);
        
        int[] temp=new int[2];
        
        temp[0]=left[1]+1;
        temp[1]=right[0]+1;
        max=Math.max(Math.max(left[1], right[0]) + 1,max);
        return temp;
    }
}