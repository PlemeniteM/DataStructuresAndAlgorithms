class Solution {
    class Pair{
        int el;
        int fr;
        Pair(int el,int fr){
            this.el=el;
            this.fr=fr;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> ht=new HashMap<>();
        for(int i:nums){
            if(ht.containsKey(i)){
                ht.put(i,ht.get(i)+1);
            }
            else{
                ht.put(i,1);
            }
        }
        Pair[] vals=new Pair[ht.size()];
        int idx=0;
        for(Integer i:ht.keySet()){
            Pair p=new Pair(i,ht.get(i));
            vals[idx]=p;
            idx++;
        }
        PriorityQueue<Pair> pt=new PriorityQueue<>((a,b)->a.fr-b.fr);
        for(int i=0;i<vals.length;i++){
            Pair temp=vals[i];
          if(i<k){
              pt.add(temp);
          }
          else{
           if(temp.fr>pt.peek().fr){
              pt.remove();
              pt.add(temp);
          }   
          }
          
      }
        int i=0;
        int[] ans=new int[k];
        while(pt.size()>0){
            Pair temp=pt.remove();
            ans[i]=temp.el;
            i++;
        }
        return ans;
        
    }
}