package problem76;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String highstack, String needle) {
        Map<Character, Integer> needleMap = new HashMap<>();
        for (char c : needle.toCharArray()) {
            int count = needleMap.containsKey(c) ? needleMap.get(c) : 0;
            needleMap.put(c, count + 1);
        }

        int minStart = 0, minEnd = highstack.length();
        boolean empty = true;
        int start = 0, end = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();
        while (start < highstack.length()) {
            if (!more(countMap, needleMap) && end < highstack.length()) {
                char currentChar = highstack.charAt(end);
                int count = countMap.containsKey(currentChar) ? countMap.get(currentChar) : 0;
                countMap.put(currentChar, count + 1);
                end++;
            } else {
                if (more(countMap, needleMap)) {
                    empty = false;
                    if (end - start < minEnd - minStart) {
                        minEnd = end;
                        minStart = start;

                    }
                }
                char startChar = highstack.charAt(start);
                start++;
                int count = countMap.get(startChar);
                if (count > 1) {
                    countMap.put(startChar, count - 1);
                } else {
                    countMap.remove(startChar);
                }
            }
        }
        if (empty)
            return "";
        else
            return highstack.substring(minStart, minEnd);
    }

    boolean more(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (!map1.keySet().containsAll(map2.keySet()))
            return false;
        for (Character character : map2.keySet()) {
            if (map1.get(character) < map2.get(character))
                return false;
        }
        return true;
    }
}