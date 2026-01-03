class Solution:
    def numOfWays(self, n: int) -> int:
        MOD=1_000_000_000+7
        f_sym=6
        f_non=6
        for i in range(2, n+1):
            f_sym_temp=f_sym
            f_sym = (3 * f_sym + 2 * f_non) % MOD
            f_non = (2 * f_sym_temp + 2 * f_non) % MOD
        return (f_sym + f_non) % MOD