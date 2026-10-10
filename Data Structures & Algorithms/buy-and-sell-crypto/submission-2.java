class Solution {
    public int maxProfit(int[] prices) {
        var minPrice = Integer.MAX_VALUE;
        var maxProfit = 0;

        for (var price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
