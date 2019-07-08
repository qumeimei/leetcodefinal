283. Move Zeroes
Easy

2116

79

Favorite

Share
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
//理解
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length<=1)
            return;
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,start,i);//理解
                start++;//理解之前的都是0或者自己，没必要在做
            }
        }
    }
        public void swap(int[] nums,int start, int index){
            int temp=nums[start];
            nums[start]=nums[index];
            nums[index]=temp;
        }
    
}