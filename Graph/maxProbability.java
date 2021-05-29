class Solution {
    class Pair {
        int node;
        double wt;
        Pair(int n,double wt){
            this.node=n;
            this.wt=wt;
            
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] graph=new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(new Pair(edges[i][1],succProb[i]));
            graph[edges[i][1]].add(new Pair(edges[i][0],succProb[i]));
        }
        boolean[] visited=new boolean[n];

        PriorityQueue<Pair> pt=new PriorityQueue<>((a, b) -> (((Double) b.wt).compareTo((Double) a.wt)));
        pt.add(new Pair(start,1));
        double ans=0;
        while(pt.size()>0){
            Pair rem=pt.remove();
            if(rem.node==end){
                ans=Math.max(rem.wt,ans);
                break;
            }
            if(visited[rem.node]){
                continue;
            }
            visited[rem.node]=true;
            
            for(Pair p:graph[rem.node]){
            if(!visited[p.node])pt.add(new Pair(p.node,p.wt*rem.wt));
            }
        }
        return ans;
    }
   
}