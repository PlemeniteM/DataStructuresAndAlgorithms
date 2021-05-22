class Solution {
     public long MOD=(long)1e9+7;
     public long imgMultiply(Node left, Node right){
         if(left == null || right == null){
             return 0;
         }
         long sump = 0;
         
         sump += (left.data * right.data)%MOD;
         
         sump+=imgMultiply(left.left, right.right)%MOD;
         
         sump+=imgMultiply(left.right, right.left)%MOD;
         
         return sump%MOD;
     }
    public long imgMultiply(Node root)
    {
        // code here
        if(root == null){
            return 0;
        }
        long product = imgMultiply(root.left, root.right)%MOD;
        return (product + (root.data*root.data))%MOD;
    }
}