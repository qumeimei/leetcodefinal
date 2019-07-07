//DP有正负数
class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int res=nums[0];
        int minCur=nums[0];
        int maxCur=nums[0];
        int minPre=nums[0];
        int maxPre=nums[0];
        
        for(int i=1;i<nums.length;i++){
            minCur=Math.min(nums[i]*maxPre,Math.min(nums[i],nums[i]*minPre));
            maxCur=Math.max(nums[i]*minPre,Math.max(nums[i],nums[i]*maxPre));
            minPre=minCur;
            maxPre=maxCur;
            res=Math.max(res,maxCur);
            
        }
        return res;
    }
}