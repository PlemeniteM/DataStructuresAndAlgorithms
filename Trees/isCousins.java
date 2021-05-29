class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null||root.left==null&&root.right==null)return false;
        Queue<TreeNode> qt=new ArrayDeque<>();
        qt.add(root);
        while(qt.size()>0){
            int count=qt.size();
            boolean fx=false,fy=false;
            int px=0,py=0;
            for(int i=0;i<count;i++){
                TreeNode temp=qt.remove();
                if(temp.left!=null){
                    if(temp.left.val==x){fx=true;px=temp.val;}
                    else if(temp.left.val==y){fy=true;py=temp.val;}
                    qt.add(temp.left);
                    
                }
                if(temp.right!=null){
                    if(temp.right.val==x){fx=true;px=temp.val;}
                    else if(temp.right.val==y){fy=true;py=temp.val;}
                    qt.add(temp.right);
                }
               
            }
            if(fx&&fy){
                if(px==py)return false;
                else return true;
            }
            
            
        }
        return false;
    }
}