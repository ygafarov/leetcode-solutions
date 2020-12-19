package problem9;

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(-21112));
    }

    public boolean isPalindrome(int num) {
        if (num < 0)
            return false;
        Stack<Integer> digits = new Stack<>();
        int number = num;
        while (number != 0) {
            int lastDigit = number % 10;
            number /= 10;
            digits.push(lastDigit);
        }
        number = num;
        while (number != 0) {
            int lastDigit = number % 10;
            number /= 10;
            if (digits.empty() || digits.pop() != lastDigit) {
                return false;
            }
        }
        return true;
    }
}