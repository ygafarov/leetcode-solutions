package problem5;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("asad"));
    }


    public String longestPalindrome(String input) {
        if (input.isEmpty())
            return "";
        int[] polyLength = new int[input.length()];
        for (int i = 0; i < polyLength.length; i++) {
            polyLength[i] = 1;
        }

        int max = 1;
        String result = input.substring(0, 1);
        for (int rightIndex = 1; rightIndex < polyLength.length; rightIndex++) {
            int leftIndex = rightIndex - polyLength[rightIndex - 1] - 1;
            if (leftIndex >= 0 && input.charAt(leftIndex) == input.charAt(rightIndex))
                polyLength[rightIndex]++;
            else
                continue;
            if (polyLength[rightIndex] > max) {
                max = polyLength[rightIndex];
                result = input.substring(leftIndex, rightIndex + 1);
            }
        }

        return result;

    }
}