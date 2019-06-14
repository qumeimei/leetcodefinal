class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        if(prices==null||prices.length<2)
            return res;
        int buy=-prices[0];
        int sell=0;
        int reset=0;
        for(int i=1;i<prices.length;i++){
            int prebuy=buy;
            int presell=sell;
            int prereset=reset;
            buy=Math.max(prebuy,prereset-prices[i]);
            sell=Math.max(presell,prebuy+prices[i]);
            reset=Math.max(prereset,presell);

        }
        return sell;
    }