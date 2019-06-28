// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

// Example:

// Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
// Output: [3,3,5,5,6,7] 
// Explanation: 

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

// Follow up:
// Could you solve it in linear time?
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[0];
        int n=nums.length;
        int[] res=new int[n-k+1];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            max=Math.max(max,nums[i]);
        }
        res[0]=max;
        for(int i=k;i<n;i++){
            if(nums[i]>=res[i-k]){
                res[i-k+1]=nums[i];
            }
            else{
                if(nums[i-k]!=res[i-k])
                    res[i-k+1]=res[i-k];
                else{
                    int temp=Integer.MIN_VALUE;
                    for(int j=i-k+1;j<=i;j++){
                        temp=Math.max(temp,nums[j]);
                    }
                    res[i-k+1]=temp;
                }
            }
        }
        return res;
    }
}


//We create a Deque, Qi of capacity k, that stores only useful elements of current window of k elements. An element is useful if it is in current window 
// nd is greater than all other elements on left side of it in current window. We process all array elements one by one and maintain Qi to contain useful 
// ements of current window and these useful elements are maintained in sorted order. The element at front of the Qi is the largest and element at rear 
// of Qi is the smallest of current window.


// 双q从后边开始移除 前边都是最大的数
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[0];
        int n=nums.length;
        int[] res=new int[n-k+1];
        int max=Integer.MIN_VALUE;
        Deque<Integer> dq=new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            while(dq.size()!=0 &&nums[dq.peekLast()]<=nums[i]){
            	dq.pollLast();
            }
            dq.add(i);
        }
        res[0]=nums[dq.peek()];
        
        for(int i=k;i<n;i++){
        	while(dq.size()!=0 && dq.peek()<=i-k){
                dq.poll();
            }
        		
        	while(dq.size()!=0 && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
        	dq.add(i);
        	res[i-k+1]=nums[dq.peek()];

        }
        return res;
    }
}

//priority queue, 每次重排k 个 nlnk
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[0];
        int n=nums.length;
       PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>(){
           public int compare (Integer i1, Integer i2){
               return i2 - i1;
           } 
        });
        for(int i=0;i<k;i++){
        	que.add(nums[i]);
        }
        int[] res=new int[n-k+1];
        res[0]=que.peek();
        for(int j=k;j<n;j++){
        	que.remove(nums[j-k]);
        	que.add(nums[j]);
        	res[j-k+1]=que.peek();
        }
        return res;
    }
}
