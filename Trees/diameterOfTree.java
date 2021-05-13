class Solution{
	static class Diameter{
		int diameter;
		int height;
	}
	//Approach 1
	//We create a pair and for each subtree we return its diameter and height
	//Diameter of given tree is maximum of diameter of all subtrees
	public static Diameter diameter1(Node node){
        if(node==null){
        	Diameter temp=new Diameter();
        	temp.diameter=0;
        	temp.height=-1;
        	return temp;
        }

		Diameter left=diameter1(node.left);
		Diameter right=diameter1(node.right);

		Diameter ans=new Diameter();

		ans.height=Math.max(left.height,right.height)+1;
		ans.diameter=Math.max(left.height+right.height+2,Math.max(left.diameter,right.diameter));

		return ans;
	}

    //Approach 2
    //We return height of each subtree
    //and update the diameter using travel and change strategy
	static int dia=0;
	public static int diameter2(Node node){
        if(node==null){
        	return -1;
        }
		int ld=diameter2(node.left);
		int rd=diameter2(node.right);
        
		dia=Math.max(dia,ld+rd+2);

		return Math.max(ld,rd)+1;
	}
}