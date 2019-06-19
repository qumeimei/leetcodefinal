//难点在于空间O（1）高位存下一个状态低位存当前状态
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0||board[0].length==0)
            return;
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                int count=countNeighbourLife(board,i,j);
                if((board[i][j]==1&&count>=2&&count<=3)||(board[i][j]==0&&count==3))
                    board[i][j]+=2;
                }
        }
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                board[i][j]>>=1;
            }
        }
                
    }
    public int countNeighbourLife(int[][]board,int i,int j){
        int count=0;
        int[] x={1,1,1,0,0,-1,-1,-1,};
        int[] y={1,0,-1,-1,1,1,0,-1};
        
        for(int k=0;k<=7;k++){
            int dx=i+x[k];
            int dy=j+y[k];
            if(dx>=0&&dx<board.length&&dy>=0&&dy<board[0].length)
                if((board[dx][dy]&1)==1)
                    count++;
        }
        return count;
    }