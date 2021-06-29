class Solution {
    public int longestOnes(int[] nums, int k) {
        if(k==0){
            int count=Integer.MIN_VALUE;
            int temp=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==1)temp++;
                if(nums[i]==0){count=Math.max(count,temp);temp=0;}
            }
            return Math.max(count,temp);
        }
        Queue<Integer> qt=new ArrayDeque<>();
        int coz=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            System.out.print(i+" ");
           if(coz>=k){
               if(nums[i]==1){
                   qt.add(nums[i]);
               }
               else{
                   ans=Math.max(ans,qt.size());
                   while(qt.size()>0&&qt.peek()!=0){
                      qt.poll();
                   }
                   qt.poll();
                   qt.add(nums[i]);
                   coz++;
               }
           }
           else{
               qt.add(nums[i]);
               if(nums[i]==0)coz++;
           }
        }
        return Math.max(ans,qt.size());
    }
    
}