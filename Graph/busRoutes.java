class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)return 0;
        HashMap<Integer,ArrayList<Integer>> buses=new HashMap<>();
        boolean[] visited=new boolean[routes.length];

        for(int i=0;i<routes.length;i++){
        	for(int j=0;j<routes[i].length;j++){
        		ArrayList<Integer> bus=buses.getOrDefault(routes[i][j],new ArrayList<>());
        		bus.add(i);
        		buses.put(routes[i][j],bus);
        	}
        }
        
        Queue<Integer> stop=new ArrayDeque<>();
        stop.add(source);
        int ride=0;
        while(!stop.isEmpty()){
        	int len=stop.size();
        	ride++;
        	for(int i=0;i<len;i++){
        		int cur=stop.remove();
                ArrayList<Integer> currBus=buses.get(cur);
                for(int j:currBus){
                	if(visited[j])continue;
                	visited[j]=true;
                	for(int st=0;st<routes[j].length;st++){
                		if(routes[j][st]==target)return ride;
                		stop.add(routes[j][st]);
                	}
                }
        	}
        }
        return -1;
    }
}