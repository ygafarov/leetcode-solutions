class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        total_sum = 0
        for num in nums:
            divisors = self.find_divisors(num)
            if len(divisors) == 4:
                total_sum += sum(divisors)
        return total_sum

    def find_divisors(self, n: int) -> List[int]:
        max_divisor = int(math.sqrt(n)) + 2
        divisors = set()
        for i in range(1, max_divisor):
            if n % i == 0:
                divisors.add(i)
                divisors.add(n // i)
        return divisors