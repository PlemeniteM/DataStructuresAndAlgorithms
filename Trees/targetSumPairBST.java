class Solution{

	public static boolean find(Node node,int data){

        if(node==null)return false;

		if(node.data==data){
			return true;
		}

		else if(node.data<data){
			return find(node.right,data);
		}

		else{
			return find(node.left,data);
		}
	}

	public static void targetSumPairBST(Node node,int tar){

       if(node==null)return;

       targetSumPairBST(node.left,tar);
       int temp=tar-node.data;

       if(node.data<temp){
       	   if(find(root,node)){
       	   	   System.out.println(node.data+" "+temp);
       	   }
       }
       
       targetSumPairBST(node.right,tar);

	}
}