class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> allNums=new ArrayList<>();
        for(int i=1;i<=9;i++){
            addAll(allNums,i,n);
        }
        return allNums;
    }

    public void addAll(List<Integer> nums,int i,int n){
        if(i>n)return;
        nums.add(i);
        for(int j=0;j<10;j++){
            if(10*i+j>n)return;//This line improves efficiency as recusrive calls will be reduced
            addAll(nums,10*i+j,n);
        }
    }
}