//从左右往中间走，小的开始加，一直到碰到大的，然后从新开始
class Solution {
    public int trap(int[] height) {
        int res=0;
        if(height==null||height.length<3)
            return res;
        int len=height.length;
        int left=0;
        while(height[left]==0) left++;
        int right=len-1;
        while(height[right]==0) right--;
        int stand=0;
        while(left<right){
                stand=Math.min(height[left],height[right]);
                if(height[left]==stand){
                    left++;
                    while(left<right&&height[left]<=stand) {  
                        res+=stand-height[left];
                        left++;
                    }
                }
                else{
                    right--;
                    while(right>left&&height[right]<=stand) {
                        res+=stand-height[right];
                        right--;
                    }
                }
            }
        return res;    
    }
}