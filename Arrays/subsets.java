class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(nums,ans,temp,0);
        return ans;
    }

    //Solution 1
    public void helper(List<Integer> temp,List<List<Integer>> ans,int[] nums,int idx){
        if(idx==nums.length){
        	ans.add(new ArrayList<>(temp));
        	return;
        }


    	temp.add(nums[idx]);
    	helper(temp,ans,nums,idx+1);
    	temp.remove(temp.size()-1);
    	helper(temp,ans,nums,idx+1);
    }

    //Solution 2
    public List<List<Integer>> helper(int[] nums,int idx){
        if(idx>=nums.length){
            List<List<Integer>> val=new ArrayList<>();
            List<Integer> temp=new ArrayList<>();
            val.add(temp);
            
            return val;
        }
        List<List<Integer>> temp=helper(nums,idx+1);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<temp.size();i++){
            List<Integer> te=new ArrayList<>(temp.get(i));
            ans.add(te);
            ans.get(i).add(nums[idx]);
        }
        for(List<Integer> t:temp){
            ans.add(t);
        }
       
        return ans;
        
    }
}
