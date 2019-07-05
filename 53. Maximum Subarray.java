Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Method 1: Greey
class Solution {
    public int maxSubArray(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;
    	int res=nums[0];
    	int temp=res;
    	for(int i=1;i<nums.length;i++){
    		if(temp<0)
    			temp=0;
    		temp=temp+nums[i];
    		res=Math.max(res,temp);


    	}
    	return res;  
    }
}

Method divide and conquer
class Solution {
    public int maxSubArray(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;
        if(nums.length==1)
            return nums[0];
            
    	int left=0;
    	int right=nums.length-1;
    	int mid=(left+right)/2;
    	int leftValue=maxArray(nums,left,mid);
    	int rightValue=maxArray(nums,mid+1,right);
    	int midValue=maxMid(nums,left,mid,right);
    	return Math.max(Math.max(leftValue,midValue),rightValue);

    	
    }
    public int maxArray(int[] nums,int start,int end){
    	if(start==end)
    		return nums[start];
    	int mid=(start+end)/2;
    	int left=maxArray(nums,start,mid);
    	int right=maxArray(nums,mid+1,end);
    	int midValue=maxMid(nums,start,mid,end);
    	return Math.max(Math.max(left,midValue),right);
    }
    public int maxMid(int[] nums,int start,int mid,int end){
    	int resLeft=Integer.MIN_VALUE;
    	int temp=0;
    	for(int i=mid;i>=start;i--){
    		temp+=nums[i];
    		resLeft=Math.max(resLeft,temp);
    	}
    	int resRight=Integer.MIN_VALUE;
    	temp=0;
    	for(int i=mid+1;i<=end;i++){
    		temp+=nums[i];
    		resRight=Math.max(temp,resRight);
    	}
    	return resLeft+resRight;
    }
}

#给出位置 local global
Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return the minimum one in lexicographical order)

Example
Example 1:

Input: [-3, 1, 3, -3, 4]
Output: [1, 4]
Example 2:

Input: [0, 1, 0, 1]
Output: [0, 3]
Explanation: The minimum one in lexicographical order.


public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        List<Integer> res=new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        if(A==null||A.length==0)
        return res;
        int result=A[0];
        int temp=A[0];
        int tempLeft=0;
        int tempRight=0;
        for(int i=1;i<A.length;i++){
            if(temp<0){
                temp=A[i];
                tempLeft=i;
                tempRight=i;
            }
            else{
                temp+=A[i];
                tempRight=i;
            }
            if(temp>result){
                result=temp;
                res.set(0,tempLeft);
                res.set(1,tempRight);
            }
                
            }
            return res;
    }
}
