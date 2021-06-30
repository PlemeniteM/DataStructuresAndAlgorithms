class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;//if root is null or none of the node is found
        if(root==p)return root;//if root is p  
        if(root==q)return root;//if root is q
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null&&right==null)return null;//if none of nodes are found in left or right subtree
        if(left!=null&&right!=null)return root;//if nodes belong to opposite subtrees
        return left==null?right:left;//if both nodes are in left then return left otherwise return right
    }
    
}