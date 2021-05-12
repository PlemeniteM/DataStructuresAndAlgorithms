class Solution{
    static ArrayList<TreeNode> path;
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        path = new ArrayList<>();
        nodeToRootPath(root, target);
        ArrayList<Integer> nodes = new ArrayList<>();
        for(int i = 0; i < path.size(); i++){
            kLevelDown(path.get(i), k - i, nodes, i == 0 ? null : path.get(i - 1));
        }
        return nodes;
	}
	public static void kLevelDown(TreeNode node, int k, ArrayList<Integer> nodes, TreeNode blocker){
            if(node==null||k<0||node==blocker){
            	return;
            }
            if(k==0){
            	nodes.add(node.val);
            }
            kLevelDown(node.left,k-1,nodes,blocker);
            kLevelDown(node.right,k-1,nodes,blocker);
	}
	public static boolean nodeToRootPath(TreeNode node, TreeNode target){
          if(node==null){
          	return false;
          }
          if(node==target||nodeToRootPath(node.left,target)||nodeToRootPath(node.right,target)){
          	path.add(node);
          	return true;
          }
          return false;

	}
}