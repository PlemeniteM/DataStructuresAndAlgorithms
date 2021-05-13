class Solution{
	  static int tilt = 0;

	  //Approach is post-order DFS
	  //We calculate tilt using post-order DFS
	  //For each subtree we return its sum in post order and add its tilt to the overall tilt of the tree
      public static int tilt(Node node){
         if(node==null)return 0;
         int lsum=tilt(node.left);
         int rsum=tilt(node.right);
     
         tilt+=Math.abs(lsum-rsum);
         return lsum+rsum+node.data;
      }

}