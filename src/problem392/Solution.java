package problem392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        char[] charsToSearch = s.toCharArray();
        int ind = 0;
        for (char ch : t.toCharArray()) {
            if (ch == charsToSearch[ind]) {
                ind++;
                if (ind == s.length())
                    return true;
            }
        }
        return false;
    }
}