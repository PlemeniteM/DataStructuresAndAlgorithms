class Solution {
    int currIdx=0;//Current Node in preorder
    Map<Integer,Integer> inord=new HashMap<>(); //This will store inorder value-->index as key-->value pair
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==1||inorder.length==1)return new TreeNode(preorder[0],null,null);
        for(int i=0;i<inorder.length;i++){
            inord.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
        
    }
     public TreeNode helper(int[] pre,int left,int right){
         if(left>right)return null;
         
         int rot=pre[currIdx++];
         TreeNode root=new TreeNode(rot);
         
        
         root.left=helper(pre,left,inord.get(rot)-1);
         root.right=helper(pre,inord.get(rot)+1,right);
         return root;
    }
}