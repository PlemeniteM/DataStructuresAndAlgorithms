class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0){
            int[] temp=new int[numCourses];
            for(int i=0;i<temp.length;i++){
                temp[i]=i;
            }
            return temp;
        } 
        
        //Making graph
        List<Integer>[] graph=new ArrayList[ numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] t:prerequisites){
            graph[t[0]].add(t[1]);
        }
        
        //Checking if cycle exists
        int[] visite=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(cycle(graph,i,visite))return new int[0];
        }
        //We check for cycle because topological sort only exists in acyclic directed graph
        //Topological sort using dfs
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[ numCourses];
        for(int i=0;i< numCourses;i++){
            if(!visited[i]){
                tsort(graph,i,visited,st);
            }
        }
        
        //Order of tasks(with the top element to be done at last and the bottom at the beginning)
        int[] ans=new int[ numCourses];
        int i= numCourses-1;
        while(st.size()>0){
            ans[i]=st.pop();
            i--;
        }
        return ans;
    }
    //for cycle detection
    public boolean cycle(List<Integer>[] graph,int src,int[] visited){
        if(visited[src]==2)return true;
        if(visited[src]==1)return false;
        visited[src]=2;
        for(int nbr:graph[src]){
            if(cycle(graph,nbr,visited))return true;
        }
        visited[src]=1;
        return false;
    }
    //for topological sorting
    public void tsort(List<Integer>[] graph,int src,boolean[] visited,Stack<Integer> st){
        visited[src]=true;
        for(int nbr:graph[src]){
            if(!visited[nbr]){
                tsort(graph,nbr,visited,st);
            }
        }
        st.push(src);
    }
}