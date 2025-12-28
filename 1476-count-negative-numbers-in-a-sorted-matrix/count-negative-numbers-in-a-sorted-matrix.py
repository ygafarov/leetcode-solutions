class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        n_rows = len(grid)
        n_cols = len(grid[0])

        result = 0
        i = n_rows - 1
        j = 0
        while i >= 0:
            while j < n_cols and grid[i][j] >= 0:
                j += 1
            if j < n_cols:
                result += n_cols - j
            i -= 1
        return result