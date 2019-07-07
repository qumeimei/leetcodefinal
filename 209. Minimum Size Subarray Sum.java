//n*n
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res=Integer.MAX_VALUE;
        if(nums==null||nums.length==0)
            return 0;
        int[] sum=new int[nums.length+1];
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp+=nums[i];
            sum[i+1]=temp;
            if(temp>=s){
            for(int j=i;j>=0;j--){
                if(sum[j]<=sum[i+1]-s){
                    res=Math.min(res,i+1-j);
                }
            }
        }
            
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
//n

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res=Integer.MAX_VALUE;
        if(nums==null||nums.length==0)
            return 0;
        int start=0;
        int end=0;
        int temp=0;
        while(end<nums.length){
            temp+=nums[end];
            end++;
            while(temp>=s&&start<end){
                res=Math.min(res,end-start);
                temp-=nums[start];
                start++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}