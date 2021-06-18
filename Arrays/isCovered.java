class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> ht=new HashSet<>();
        for(int[] r:ranges){
            int i=r[0];
            int j=r[1];
            while(i<=j){
                ht.add(i);
                i++;
            }
        }
        boolean all=true;
        while(left<=right){
            if(!ht.contains(left)){
                all=false;
                break;
            }
            left++;
        }
        return all;
    }
}