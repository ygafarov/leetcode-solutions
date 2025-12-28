class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        result = [0] * (2 * n)
        result[2 * n - 1] = nums[2 * n - 1]
        for i in range(2 * n - 1):
            target_index = (i * 2) % (2 * n - 1)
            result[target_index] = nums[i]
        return result