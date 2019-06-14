class Solution {
    public int maxArea(int[] height) {
        int res=0;
        if(height==null||height.length<2)
            return res;
        int left=0;
        int right=height.length-1;
        while(left<right){
            res=Math.max(res,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<=height[right]){
                left++;
            }
            else right--;
        }
        return res;
        
    }
}