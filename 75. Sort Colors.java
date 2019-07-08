Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
#每次存最小在左边最大在右边
class Solution {

public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
    int left=0;
    int right=nums.length-1;
    int index=0;
    int min=0;
    int max=2;
    while(max>min){
    while(index<=right){
        if(nums[index]==min){
            swap(nums,left,index);
                index++;
                left++;
            }

        else if (nums[index]==max){
            swap(nums,index,right);
            right--;
        }
        else {
            index++;
        }
        }
    max--;
    min++;
    }
}
    public void swap(int[] nums,int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

}