class Solution{
	static class MedianQueue{
		PriorityQueue<Integer> left;
		PriorityQueue<Integer> right;
		MedianQueue(){
			left=new PriorityQueue<>(Collections.reverseOrder());
			right=new PriorityQueue<>();
		}
		public static void add(int val){
           if(this.size()==0){
           	   left.add(val);
           	   return;
           }
           if(right.size()>0&&val>right.peek()){
           	right.add(val);
           }
           else{
           	   left.add(val);
           }
           if(left.size()-right.size()==2){
           	   right.add(left.remove());
           }
           else if(right.size()-left.size()==2){
           	left.add(right.remove());
           }
		}
		public static int remove(){
          if(this.size()==0){
          	System.out.println("Underflow");
          	return -1;
          }
          if(left.size()>=right.size()){
          	return left.remove();
          }
          else{
          	return right.remove();
          }
		}
		public static int peek(){
          if(this.size()==0){
          	System.out.println("Underflow");
          	return -1;
          }
          if(left.size()>=right.size()){
          	return left.peek();
          }
          else{
          	return right.peek();
          }
		}
		public static int size(){
          return left.size()+right.size();
		}
	}
	public static void main(String[] args){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianQueue qu = new MedianQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
	}
}