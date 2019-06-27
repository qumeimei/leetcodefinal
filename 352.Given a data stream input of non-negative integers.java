// Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

// For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

// [1, 1]
// [1, 1], [3, 3]
// [1, 1], [3, 3], [7, 7]
// [1, 3], [7, 7]
// [1, 3], [6, 7]
// Follow up:
// What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


//相差一就考慮插入
class SummaryRanges {
     class Interval {
        int start;
        int end;
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
     Map<Integer, Interval> smap;
    Map<Integer, Interval> emap;
    Set<Integer> added;
    
    private TreeSet<Interval> intervals;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        smap = new TreeMap<>();
        emap = new TreeMap<>();
        added = new HashSet<>();
    }
    
    public void addNum(int val) {
        if(added.contains(val)) return;
        added.add(val);
        
        Interval s = smap.get(val+1);
        Interval e = emap.get(val-1);
        
        smap.remove(val+1);
        emap.remove(val-1);
 
        Interval n = new Interval(e!=null?e.start:val, s!=null?s.end:val);
        smap.put(n.start, n);
        emap.put(n.end, n);
    }
    
    public int[][] getIntervals() {
        int c = 0;
        int[][] res = new int[smap.size()][2];
        for (Interval i: smap.values()){
            res[c][0]=i.start;
            res[c][1]=i.end;
            c++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
