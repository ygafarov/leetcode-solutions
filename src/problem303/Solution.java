package problem303;

class NumArray {
    int sum[];

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        int summary = 0;
        for (int i = 0; i < sum.length; i++) {
            summary += nums[i];
            sum[i] = summary;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - (i > 0 ? sum[i - 1] : 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */