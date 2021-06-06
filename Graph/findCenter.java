class Solution {
    public int findCenter(int[][] edges) {
        // int vtces=edges.length+1;
        int ans=0;
        for(int i=0;i<2;i++){
            int v1=edges[0][0];
            int v2=edges[0][1];
            int v3=edges[1][0];
            int v4=edges[1][1];
            if(v1==v3||v1==v4){
                ans=v1;
                break;
            }
            else{
                ans=v2;
            }
        }
//         List<Integer>[] graph=new ArrayList[vtces];
//         for(int i=0;i<vtces;i++){
//             graph[i]=new ArrayList<>();
//         }
//         for(int[] edge:edges){
//             int v1=edge[0]-1;
//             int v2=edge[1]-1;
//             graph[v1].add(v2);
//             graph[v2].add(v1);
//         }
       
//         for(int i=0;i<graph.length;i++){
//             List<Integer> ed=graph[i];
//             if(ed.size()==vtces-1){
//                 ans=i;
//                 break;
//             }
//         }
        return ans;
    }
}