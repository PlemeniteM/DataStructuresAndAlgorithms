class Solution{

	public static int lowestCommonAncestorBST(Node node, int d1, int d2) {

          if(node==null)return 0;
    
          //if d1 and d2 lie on opposite sides of current node or either d1 or d2 is equal to current node
          if(d1==node.data||d2==node.data||d1>node.data&&d2<node.data||(d1<node.data&&d2>node.data)){
                  return node.data;
          }
          //If both are smaller than current node then LCA must be in left subtree
          else if(d1<node.data&&d2<node.data){
              int ans=lowestCommonAncestorBST(node.left,d1,d2);
              return ans;
          }

          //If both are bigger than current node then LCA must be in right subtree
          else{
              int temp=lowestCommonAncestorBST(node.right,d1,d2);
              return temp;
          }


    }
}