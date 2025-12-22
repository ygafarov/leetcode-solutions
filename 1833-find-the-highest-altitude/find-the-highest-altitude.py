class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        result=0
        sum=0
        for n in gain:
            sum+=n;
            result = max(result, sum)
        return result