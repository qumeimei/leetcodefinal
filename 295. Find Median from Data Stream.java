Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?



class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;

    /** initialize your data structure here. */
    public MedianFinder() {
        max=new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b-a;
        }
    });
        min=new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if(max.size()==0)
            max.add(num);
        else if(num>max.peek()){
            min.add(num);
        }
        else max.add(num);
         while(max.size()<min.size()){
            max.add(min.poll());
        }
        while(min.size()<max.size()-1){
            min.add(max.poll());
        }
        
    }
    
    public double findMedian() {
        if(max.size()==min.size())
            return (max.peek()+min.peek())/2.0;
        else
            return max.peek()/1.0;
       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
