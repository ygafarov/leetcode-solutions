package problem70;

class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int a1 = 1;
        int a2 = 2;
        int an = 3;
        for (int i = 3; i <= n; i++) {
            an = a1 + a2;
            a1 = a2;
            a2 = an;
        }
        return an;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }
}