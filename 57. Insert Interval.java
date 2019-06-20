class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();
       
        if(intervals==null||intervals.length==0){
            res.add(newInterval);
            int[][] res1=new int[1][2];
            return res.toArray(res1);
        }
        
        int len=intervals.length;
       
        int[] temp=new int[2];
        temp=newInterval;
        for(int i=0;i<len;i++){

            int start1=intervals[i][0];
            int end1=intervals[i][1];
            if(temp[1]<start1){
                res.add(temp);
                System.out.println(res.get(0)[0]);
                temp[0]=intervals[i][0];//会改变已经存了的数值，必须用temp=intervals[i]
                System.out.println(res.get(0)[0]);
                }
            else if(temp[0]>end1){
                res.add(intervals[i]);
            }
            else{
                temp[0]=Math.min(temp[0],start1);
                temp[1]=Math.max(temp[1],end1);
            }
            
        }
        res.add(temp);
        int[][] res1=new int[res.size()][2];
        

        return res.toArray(res1);
            
    }
}