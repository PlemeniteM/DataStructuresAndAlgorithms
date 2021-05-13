class Solution {
    class BST{
        boolean bst;
        int sum;
        int max;
        int min;
    }
    int sum=Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        if(root==null)return 0;
        isBst(root);
       
        return sum>0?sum:0;
    }
    
    public BST isBst(TreeNode root){
        if(root==null){
            BST temp=new BST();
            temp.bst=true;
            temp.sum=0;
            temp.max=Integer.MIN_VALUE;
            temp.min=Integer.MAX_VALUE;
            return temp;
        }
        
        BST left=isBst(root.left);
        BST right=isBst(root.right);
        
        BST curr=new BST();
        curr.bst=left.bst&&right.bst&&(left.max<root.val&&root.val<right.min);
        curr.sum=left.sum+right.sum+root.val;
        curr.max=Math.max(root.val,right.max);
        curr.min=Math.min(root.val,left.min);
        
        if(curr.bst){
            if(curr.sum>sum){
                sum=curr.sum;
            }
        }
        return curr;
    }
}