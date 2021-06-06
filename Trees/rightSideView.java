class Solution {

    //Method 1
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return new LinkedList<>();
        Deque<TreeNode> qt=new LinkedList<>();
        qt.addLast(root);
        List<Integer> ans=new ArrayList<>();
        ans.add(root.val);
        while(qt.size()>0){
            int count=qt.size();
            
            for(int i=0;i<count;i++){
                TreeNode rem=qt.removeFirst();
                if(rem.left!=null){qt.addLast(rem.left);}
                if(rem.right!=null){qt.addLast(rem.right);}
            }
            if(qt.size()>0){
                int val=qt.getLast().val;
                ans.add(val);
            }
            
           
        }
        return ans;
    }
    
    //Method 2
    //reverse preorder
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, result, 0);
        return result;
    }
    
    public void dfs(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }

        //this line makes sure that only the first element of every level is added to the list
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        
        dfs(curr.right, result, currDepth + 1);
        dfs(curr.left, result, currDepth + 1);
        
    }
}