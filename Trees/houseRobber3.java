class Solution {

    public int rob(TreeNode root) {
        if(root==null)return 0;
        int[] tmp=helper(root);
        return Math.max(tmp[0],tmp[1]);
    }
    
    public int[] helper(TreeNode root){
        if(root==null)return new int[]{0,0};
        
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        
        int[] temp=new int[2];
        temp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        temp[1]=left[0]+right[0]+root.val;
        
        return temp;
    }
}