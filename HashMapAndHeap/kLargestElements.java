class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pt=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(i<k){
                pt.add(nums[i]);
            }
            else{
                if(nums[i]>pt.peek()){
                    pt.remove();
                    pt.add(nums[i]);
                }
            }
        }
        return pt.peek();
    }
}