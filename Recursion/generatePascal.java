class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(numRows,ans,new ArrayList<>());
        return ans;
    }
    public List<Integer> helper(int row,List<List<Integer>> ans,List<Integer> temp){
        if(row==1){
            temp.add(1);
            ans.add(temp);
            return temp;
        }
        List<Integer> te=helper(row-1,ans,temp);
        List<Integer> ne=new ArrayList<>();
        for(int i=0;i<te.size()-1;i++){
            ne.add(te.get(i)+te.get(i+1));
        }
        ne.add(0,1);
        ne.add(1);
        ans.add(ne);
        return ne;
        
    }
}