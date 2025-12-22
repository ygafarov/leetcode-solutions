class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        max_len = 0
        l = 0
        count_zeroes = 0
        for r in range(len(nums)):
            if (nums[r] == 0):
                count_zeroes += 1
            while (count_zeroes > 1):
                if (nums[l] == 0):
                    count_zeroes -= 1;
                l += 1;
            max_len = max(max_len, r - l )
        return max_len