package problem3;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int lengthOfLongestSubstring(String string) {
        int maxLen = 0;
        Queue<Character> queue = new LinkedList<>();
        int e = 0;
        while (e < string.length()) {
            char currentChar = string.charAt(e);
            if (!queue.contains(currentChar)) {
                queue.add(currentChar);
                e++;
            } else {
                maxLen = Math.max(maxLen, queue.size());
                queue.poll();
            }
        }
        maxLen = Math.max(maxLen, queue.size());
        return maxLen;

    }
}