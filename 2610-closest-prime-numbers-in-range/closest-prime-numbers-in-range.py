class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        is_prime = [True] * (right + 1)
        is_prime[0:1] = [False] * 2
        for i in range(2, int(math.sqrt(right)) + 1):
            if (is_prime[i]):
                for j in range(i * i, right + 1, i):
                    is_prime[j] = False

        num1 = left
        while num1 <= right:
            if is_prime[num1]:
                break
            num1 += 1

        if num1 > right:
            return [-1, -1]

        min_diff = 1000_000
        global_num1 = num1
        num2 = num1 + 1
        found_num2 = False
        while num2 <= right:
            if is_prime[num2]:
                found_num2 = True
                if num2 - num1 < min_diff:
                    min_diff = num2 - num1
                    global_num1 = num1
                num1 = num2
            num2 += 1

        if not found_num2:
            return [-1, -1]

        return [global_num1, global_num1 + min_diff]