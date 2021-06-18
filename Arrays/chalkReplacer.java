class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int i:chalk)sum+=i;


        
        long temp=k%sum;
        System.out.println(temp);
        for(int i=0;i<chalk.length;i++){
            if((temp-=chalk[i])<0){
                return i;
            }
            
            
       }
        return -1;
        
        
    }
}