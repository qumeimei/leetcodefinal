//第一遍左边元素，第二遍右边元素
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i-1]*res[i-1];
        }
        int temp=1;
        for(int i=nums.length-2;i>=0;i--){
            temp*=nums[i+1];
            res[i]*=temp;
        }
        return res;
    }
}