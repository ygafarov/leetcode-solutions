package problem121;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxProfit(int[] prices) {
        int[] minPriceTo = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i])
                min = prices[i];
            minPriceTo[i] = min;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPriceTo[i] > max)
                max = prices[i] - minPriceTo[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}