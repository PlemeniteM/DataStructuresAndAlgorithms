class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we check indegree of each node
        int[] degree=new int[numCourses];
        List<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            degree[ prerequisites[i][1]]++;
        }

        //Adding those nodes whose indegree is zero
        Queue<Integer> qt=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0){
                qt.add(i);
            }
        }

        //target is to check how many nodes's indegree can be made zero
        int edgeCount= prerequisites.length;
        while(qt.size()>0){
            int temp=qt.remove();
            for(int nbr:graph[temp]){
                edgeCount--;
                if(--degree[nbr]==0){
                    qt.add(nbr);
                }
            }
        }
        //if edgeCount is zero it means that indegree of all nodes is zero hence graph is acylic and we can apply topological sort
        //otherwise graph has a cycle and topological sort can't be applied 
        return edgeCount==0;
    }
}