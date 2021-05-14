class Solution{
	//We need to replace every node with values larger than itself present in the BST
	//Also inorder traversal of BST visits the tree in sorted order
	//So reverse inorder will visit in reverse order
	//We replace the node with last value of sum and update it with the original node value;
	static int sum=0;
    
	public static int rwsol(Node node){
        if(node==null)return;

		rwsol(node.right);

		int temp=node.data;
		node.data=sum;
		sum+=temp;

		rwsol(node.left);
	}
}