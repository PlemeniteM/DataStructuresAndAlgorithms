class Solution {
    
    int count=0,ans=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return 0;
        helper(root,k);
        return ans;
    }
    public void helper(TreeNode root,int k){
        if(root.left!=null)helper(root.left,k);
        
        count++;
        if(count==k){
            ans=root.val;
            return;
        }
        if(root.right!=null){
          helper(root.right,k);
        }
    }
    
    // //Inorder iterative
    // public int kthSmallest(TreeNode root, int k) {
    //     Stack<TreeNode> st=new Stack<>();
        
    //     while(root!=null){
    //         st.push(root);
    //         root=root.left;
    //     }
    //     while(k>0){
    //         TreeNode temp=st.pop();
    //         if(--k==0)return temp.val;
    //         TreeNode rht=temp.right;
    //         while(rht!=null){
    //             st.push(rht);
    //             rht=rht.left;
    //         }
    //     }
    //     return -1;
    // }

    //Inorder Recursive O(n)
    // public int kthSmallest(TreeNode root, int k) {
    //     ArrayList<TreeNode> al=new ArrayList<>();
    //     helper(root,al);
    //     return al.get(k-1).val;
    // }
    // public void  helper(TreeNode root,ArrayList<TreeNode> al){
    //     if(root==null)return;
    //     helper(root.left,al);
    //     al.add(root);
    //     helper(root.right,al);
    // }
}