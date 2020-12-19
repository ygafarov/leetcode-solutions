package problem746;

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        final int length = cost.length;
        int[] dp = new int[length];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return Math.min(dp[length - 1] + cost[length - 1], dp[length - 2] + cost[length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}