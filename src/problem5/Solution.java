package problem5;

class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println("bananas : " + solution.longestPalindrome("bananas"));
        System.out.println("ss : " + solution.longestPalindrome("ss"));
        System.out.println("ccc : " + solution.longestPalindrome("ccc"));
        System.out.println("assa : " + solution.longestPalindrome("assa"));
        System.out.println("asdsa : " + solution.longestPalindrome("asdsa"));
        System.out.println("assdssa : " + solution.longestPalindrome("assdssa"));
        System.out.println("assdsfsdfs12fdsa : " + solution.longestPalindrome("assdsfsdfs12fdsa"));
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
        for (int i = 1; i < polyLength.length; i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                polyLength[i] = polyLength[i - 1] + 1;
                max = Math.max(polyLength[i], max);
                int right = i;
                int left = i - polyLength[i] + 1;
                result = input.substring(left, right + 1);
            }
        }

        for (int rightIndex = 1; rightIndex < polyLength.length; rightIndex++) {
            int leftIndex = rightIndex - polyLength[rightIndex - 1] - 1;
            if (leftIndex < 0) continue;
            if (input.charAt(leftIndex) == input.charAt(rightIndex)) {
                polyLength[rightIndex] = polyLength[rightIndex - 1] + 2;
            }

            if (polyLength[rightIndex] > max) {
                max = polyLength[rightIndex];
                result = input.substring(leftIndex, rightIndex + 1);
            }
        }

        return result;
    }
}