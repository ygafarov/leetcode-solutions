package problem1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


abstract class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public abstract int f(int x, int y);
};


class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int l = 1, r = 1000;
            int mid;
            while (l <= r) {
                mid = (l + r) / 2;
                if (customfunction.f(i, mid) == z) {
                    result.add(Arrays.asList(i, mid));
                    break;
                } else if (customfunction.f(i, mid) > z)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return result;
    }


}
