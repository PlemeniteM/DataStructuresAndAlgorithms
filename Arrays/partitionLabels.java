class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> ht=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            ht.put(c,i);
        }
        List<Integer> ans=new ArrayList<>();
        int str=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,ht.get(s.charAt(i)));
            if(end==i){
                ans.add(end-str+1);
                str=end+1;
            }
            
        }
        return ans;
    }
}