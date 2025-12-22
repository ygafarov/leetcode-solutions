class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        size=len(nums)
        prefix_sum=[0]*(size+1)
        current_sum=0

        for i in range(1, len(prefix_sum)):
            current_sum+=nums[i-1]
            prefix_sum[i]=current_sum

        for i in range(len(nums)):
            sum_left=prefix_sum[i]
            sum_right = prefix_sum[-1]-prefix_sum[i+1]
            if sum_left==sum_right:
                return i
        return -1