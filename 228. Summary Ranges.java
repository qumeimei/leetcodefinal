class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<String>();
        if(nums==null||nums.length==0)
            return res;
        int start=nums[0];
        int end=nums[0];
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            temp++;
            if(nums[i]>temp){
                if(start<end){
                    StringBuilder sb=new StringBuilder();
                    sb.append(start);
                    sb.append("->");
                    sb.append(end);
                    res.add(sb.toString());
                }
                else{
                    res.add(Integer.toString(start));
                }
                start=nums[i];
                end=nums[i];
                temp=nums[i];
            }
            else{
                end=temp;
            }
        }
            if(start<end){
                    StringBuilder sb=new StringBuilder();
                    sb.append(start);
                    sb.append("->");
                    sb.append(end);
                    res.add(sb.toString());
                }
                else{
                    res.add(Integer.toString(start));
                }
        return res;
        
    }
}