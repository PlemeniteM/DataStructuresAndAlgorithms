class Solution{
	public List<List<Integer>> pathSum(TreeNode root){
		List<List<Integer>> ans=new ArrayList<>();
		helper(root,tar,new ArrayList<Integer>(),ans);
		return ans;
	}

	public void helper(TreeNode root,int tar,List<Integer> path,List<List<Integer>> ans){
		if(root==null)return;

		path.add(root.val);
        
		if(root.left==null&&root.right==null&&root.val==tar){
			ans.add(path);
			path.remove(path.size()-1);
			return;
		}
		if(root.left!=null){
			helper(root.left,tar-root.val,path,ans);
		}

		if(root.right!=null){
			helper(root.right,tar-root.val,path,ans);
		}

		path.remove(path.size()-1);
	}
}