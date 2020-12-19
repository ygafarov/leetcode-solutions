package problem53;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] sumTo = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumTo[i] = sum;
        }

        int[] minSumTo = new int[sumTo.length];
        int min = 0;
        for (int i = 1; i < sumTo.length; i++) {
            if (min > sumTo[i - 1]) {
                min = sumTo[i - 1];
            }
            minSumTo[i] = min;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < sumTo.length; i++) {
            if (sumTo[i] - minSumTo[i] > result)
                result = sumTo[i] - minSumTo[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2}));
    }
}