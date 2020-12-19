package problem338;

class Solution {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i < dp.length; i++)
            dp[i] = dp[i >> 1] + (i & 1);
        return dp;
    }

    public static void main(String[] args) {
        new Solution().countBits(40);
    }
}