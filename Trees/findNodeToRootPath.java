class Solution{
  static ArrayList<Integer> path=new ArrayList<>();
  public static boolean find(Node node, int data){
    if(node==null)return false;
    if(node.data==data){
        path.add(node.data);
        return true;
    }
    if(find(node.left,data)){
        path.add(node.data);
        return true;
    }
    if(find(node.right,data)){
        path.add(node.data);
        return true;
    }
    return false;
  }

}