class Solution{

	public static Node leftClonedTree(Node root){
        if(root==null){
        	return null;
        }

		Node temp=new Node(root.data,null,null);
		Node left=root.left;
		root.left=temp;
		temp.left=leftClonedTree(left);
		root.right=leftClonedTree(root.right);

		return root;
	}
}