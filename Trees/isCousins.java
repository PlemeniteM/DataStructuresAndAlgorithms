class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null||root.left==null&&root.right==null)return false;
        Queue<TreeNode> qt=new ArrayDeque<>();
        qt.add(root);
        while(qt.size()>0){
            int count=qt.size();
            int px=-1,py=-1;
            for(int i=0;i<count;i++){
                TreeNode temp=qt.remove();
                if(temp.left!=null){
                    if(temp.left.val==x){px=temp.val;}
                    else if(temp.left.val==y){py=temp.val;}
                    qt.add(temp.left);
                    
                }
                if(temp.right!=null){
                    if(temp.right.val==x){px=temp.val;}
                    else if(temp.right.val==y){py=temp.val;}
                     qt.add(temp.right);
                }
               
            }
            
            if(px>0&&py>0){
              if(px!=py)return true;
               else return false;
            } 
            if(px<0&&py>0||py<0&&px>0)return false;
            
            
        }
        return false;
    }
}