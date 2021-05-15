class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        //Step 1 Initially we set all values to be true as they all are potential candidates to have their own sequence
        for(int i:nums){
            map.put(i,true);
        }
       
        int maxL=0;
        for(int i:nums){

            //Here we are checking if smaller element is present because if it is then the current element will already be part of a larger sequence
            //Eg if i==4 and if we found that 3 is also present then any sequence starting with 4 will always be part of 3 
            if(!map.containsKey(i-1)){
                //Now we calculate the length of the sequence 
                int st=i;
                int inc=1;
                while(map.containsKey(st+1)){
                    st+=1;
                    inc+=1;
                }
                maxL=Math.max(maxL,inc);
            }
        }
        return maxL;
    }
}