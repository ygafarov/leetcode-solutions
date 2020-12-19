package problem7;

class Solution {
    public int reverse(int n) {
        int sign = (int) Math.signum(n);
        long result = 0;
        if (n < 0) n = -n;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        if (Math.abs(result) > Integer.MAX_VALUE)
            return 0;
        else return (int) (sign * result);
    }
}