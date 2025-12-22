class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        nums.insert(0, 0)
        nums.append(0)

        size = len(nums)
        l = 0
        count_zeroes = 1
        max_len = 0
        for r in range(1, size):
            max_len = max(max_len, r - l - 1)
            if nums[r] == 0:
                count_zeroes += 1
                if count_zeroes == k + 2:
                    l += 1
                    count_zeroes -= 1
                    while nums[l] != 0:
                        l += 1
        return max_len