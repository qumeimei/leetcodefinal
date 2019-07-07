#注意各种边界条件 输入是重复的。超出int 变long
public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res=new ArrayList<String>();
        if(nums==null||nums.length==0){
            addResulst(res,lower,upper);
            return res;
        }
        long temp=lower;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=temp&&nums[i]>temp){  //repeat value
               addResulst(res,temp,nums[i]-1);
            }
            temp=((long)nums[i]+1);//overflow
        }
        if(temp<=upper){
            addResulst(res,temp,upper);
        }
        return res;// write your code here
    }
    public void addResulst(List<String> res,long start,long end){
        if(start>=end){
            res.add(String .valueOf(start));
        }
        else{
            res.add(String.format("%d->%d",start,end));
        }
        
    }

}