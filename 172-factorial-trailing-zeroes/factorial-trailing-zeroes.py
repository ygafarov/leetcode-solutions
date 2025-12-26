class Solution:
    def trailingZeroes(self, n: int) -> int:
        divider=5
        count=0
        while(n>=divider): 
            count+=n//divider
            divider*=5
        
        return count