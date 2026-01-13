class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        min_y = min([square[1] for square in squares])
        max_y = max([square[1] + square[2] for square in squares])

        current_max = max_y
        current_min = min_y
        while current_max - current_min > 10e-6:
            middle = (current_max + current_min) / 2
            area_above = 0
            area_below = 0
            for square in squares:
                area_above += self.area_above_and_below_line(square[1], square[2], middle)[0]
                area_below += self.area_above_and_below_line(square[1], square[2], middle)[1]
            if area_above > area_below:
                current_min = middle
            else:
                current_max = middle
        return current_max

    def area_above_and_below_line(self, y, l, line_y) -> Tuple[int, int]:
        if line_y > y + l:
            return 0, l * l
        if line_y < y:
            return l * l, 0
        return (y + l - line_y) * l, (line_y - y) * l