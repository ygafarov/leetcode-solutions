class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        l = r = 0
        max_len = 0
        while l < len(nums) or r < len(nums):
            while l < len(nums) and nums[l] == 0:
                l += 1
            r = l + 1
            if r>len(nums):
                return max_len
            while r < len(nums) and nums[r] == 1:
                r += 1
            r -= 1
            if max_len < r - l + 1:
                max_len = r - l + 1
            l = r + 1
        return max_len