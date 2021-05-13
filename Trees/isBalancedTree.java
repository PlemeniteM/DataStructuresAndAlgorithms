class Solution{

	static isBalanced=true;
	public static int isBal(Node root){
        if(root==null)return -;

		int leftH=isBal(root.left);
		int rightH=isBal(root.right);
		int temp=Math.abs(leftH-rightH);
		if(temp>1){
			isBalanced=false;
		}

		return Math.max(leftH,rightH)+1;
	}
}