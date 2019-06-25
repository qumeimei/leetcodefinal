
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res=new ArrayList<>();
        if(intervals==null||intervals.length==0)
            return intervals;
        //
       Arrays.sort(intervals,new Comparator <int[]>(){
           public int compare(int[] a, int[] b){
               return a[0]-b[0];
           }
       } );
        //
        int[] temp=new int[2];
        temp=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(temp[1]<intervals[i][0]){
                res.add(temp);
                temp=intervals[i];
            }
            else if(temp[0]>intervals[i][1])
                res.add(intervals[i]);
            else{
                temp[0]=Math.min(temp[0],intervals[i][0]);
                temp[1]=Math.max(temp[1],intervals[i][1]);
            }
        }
        res.add(temp);
        int[][] res1=new int[res.size()][2];
        return res.toArray(res1);//
    }
}