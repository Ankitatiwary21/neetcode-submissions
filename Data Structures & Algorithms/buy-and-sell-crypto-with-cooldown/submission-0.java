class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        if (n == 0 || n == 1)
            return 0;

        int[] t = new int[n];
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (i < 2)
                maxDiff = Math.max(maxDiff, -prices[i]);

            if (i == 0)
                t[i] = 0;

            else if (i == 1)
                t[i] = Math.max(prices[1] - prices[0], 0);

            else {
                t[i] = Math.max(t[i - 1], prices[i] + maxDiff);

                maxDiff = Math.max(maxDiff, t[i - 2] - prices[i]);
            }
        }

        return t[n - 1];
    }
}