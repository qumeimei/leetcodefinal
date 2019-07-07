//1.p(j)-c>=p(i) 2.find i which is nearst and small
class Solution {
    public int shortestSubarray(int[] A, int K) {
        if(A==null||A.length==0)
            return -1;
        int temp=0;
        int res=Integer.MAX_VALUE;
        int[] p=new int[A.length+1];
        for(int i=0;i<A.length;i++){
            temp+=A[i];
            p[i+1]=temp;    
        }

        Deque<Integer> deque=new LinkedList<Integer>();
        for(int i=0;i<p.length;i++){
            while(!deque.isEmpty()&&p[i]<=p[deque.peekLast()])
                deque.removeLast();
            while(!deque.isEmpty()&&p[i]>=p[deque.peekFirst()]+K){
                res=Math.min(res,i-deque.removeFirst());
            }
            deque.add(i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}