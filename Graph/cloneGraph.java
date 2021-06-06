class Solution {
    public Node cloneGraph(Node node) {
//         if(node==null)return null;
//         HashMap<Node,Node> map=new HashMap<>();
//         Queue<Node> qt=new ArrayDeque<>();
//         qt.add(node);
//         Node ans=new Node(node.val,new ArrayList<Node>());
//         map.put(node,ans);
//         while(qt.size()>0){
//             Node temp=qt.remove();
//             for(Node nbr:temp.neighbors){
//                 if(!map.containsKey(nbr)){
//                     map.put(nbr,new Node(nbr.val,new ArrayList<Node>()));
//                     qt.add(nbr);
//                 }
//                 map.get(temp).neighbors.add(map.get(nbr));
                
//             }
//         }
        // return map.get(node);
        return cloneDFS(node);
    }
    HashMap<Integer,Node> graph=new HashMap<>();
    public Node cloneDFS(Node node){
        if(node==null)return null;

        if(graph.containsKey(node.val))return graph.get(node.val);

        Node ans=new Node(node.val,new ArrayList<Node>());
        graph.put(ans.val,ans);

        for(Node nbr:node.neighbors){
            ans.neighbors.add(cloneDFS(nbr));
        }
        
        return ans;
    }
}