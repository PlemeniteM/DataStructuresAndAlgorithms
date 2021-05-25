class Solution {
    int depthmax=0;
    TreeNode temp;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null)return null;
        helper(root,0);
        return temp;
    }
    private int helper(TreeNode root,int depth){
        depthmax=Math.max(depthmax,depth);
        if(root==null)return depth;
        
        int ldepth=helper(root.left,depth+1);
        int rdepth=helper(root.right,depth+1);
        
        if(ldepth==depthmax&&rdepth==depthmax){
            temp=root;
        }
        return Math.max(ldepth,rdepth);
        
    }
}