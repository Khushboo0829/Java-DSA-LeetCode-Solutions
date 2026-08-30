class Solution {
    public int maxProfit(int[] prices) {
     int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minimumPrice;

            maximumProfit = Math.max(maximumProfit, currentProfit);
            minimumPrice = Math.min(minimumPrice, prices[i]);
        }

        return maximumProfit;     
    
    }
}