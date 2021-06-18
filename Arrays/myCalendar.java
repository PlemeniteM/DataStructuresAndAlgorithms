class MyCalendar {
    SortedSet<Pair> events;
    class Pair {
        int st;
        int et;
        Pair(int st,int et){
            this.st=st;
            this.et=et;
        }
        
    }
    public MyCalendar() {
        events=new TreeSet<>(new EventSort());
    }
    class EventSort implements Comparator<Pair>{
        public int compare(Pair o1,Pair o2){
            return o1.et<=o2.st?-1:o1.st>=o2.et?1:0;
        }
    }
    public boolean book(int start, int end) {
        Pair event=new Pair(start,end);
        return events.add(event);
    }
}

