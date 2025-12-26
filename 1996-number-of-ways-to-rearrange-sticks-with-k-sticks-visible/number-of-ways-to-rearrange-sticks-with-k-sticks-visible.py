class Solution:
    def __init__(self):
        n = 1001
        self.MOD = 10 ** 9 + 7;
        self.memo = []
        for _ in range(n):
            a = [-1] * n
            self.memo.append(a)

    def rearrangeSticks(self, n: int, k: int) -> int:
        if n == k:
            return 1
        if n == 0 or k == 0: return 0

        if self.memo[n][k] == -1:
            self.memo[n][k] = (self.rearrangeSticks(n - 1, k - 1) + (n - 1) * self.rearrangeSticks(n - 1,
                                                                                                   k)) % self.MOD;

        return self.memo[n][k];