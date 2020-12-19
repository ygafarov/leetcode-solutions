package problem728;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i))
                result.add(i);
        }
        return result;
    }

    private boolean isSelfDividing(int i) {
        int temp = i;
        while (temp != 0) {
            int lastDigit = temp % 10;
            if (lastDigit == 0 || i % lastDigit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}