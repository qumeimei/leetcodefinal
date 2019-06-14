//ln(min(x,y))分割要想到最左边和最右边
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums1==null){
            if(nums2.length%2==0)
                return (nums2[nums2.length/2]+nums2[nums2.length/2-1])/2.0;
            else
                return nums2[nums2.length/2];
        }
            
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        int x=nums1.length;
        int y=nums2.length;
        int low=0;
        int high=x;
        while(low<=high){ //分割可以到最右边所以high可以等于长度
            int partX=low+(high-low)/2;
            int partY=(x+y)/2-partX;
            int Xleft=(partX==0)?Integer.MIN_VALUE:nums1[partX-1];
            int Xright=(partX==x)?Integer.MAX_VALUE:nums1[partX];
            int Yleft=(partY==0)?Integer.MIN_VALUE:nums2[partY-1];
            int Yright=(partY==y)?Integer.MAX_VALUE:nums2[partY];//分割边界条件要想到
            if(Xleft<=Yright&&Yleft<=Xright){
                if((x+y)%2==0)
                    return (double)((Math.max(Xleft,Yleft)+Math.min(Xright,Yright))/2.0);//2.0返回double
                else 
                    return (double)Math.min(Xright,Yright);

            }
            else if(Xleft>Yright){
                high=partX-1;//二分法
            }
            else if(Yleft>Xright){
                low=partX+1;
            }
        }
    throw new IllegalArgumentException();
    }
}