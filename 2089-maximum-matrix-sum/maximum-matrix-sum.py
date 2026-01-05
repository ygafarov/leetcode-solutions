class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        count_negative=0
        min_abs=1000_000
        sum_abs=0
        for row in matrix:
            for cell in row:
                sum_abs+=abs(cell)
                min_abs=min(min_abs, abs(cell))
                if(cell<0):
                    count_negative+=1
        if(count_negative%2==0):
            return sum_abs
        else:
            return  sum_abs-2*min_abs
