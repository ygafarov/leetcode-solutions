class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        area_a = (ax2 - ax1) * (ay2 - ay1)
        area_b = (bx2 - bx1) * (by2 - by1)

        overlap_left = max(ax1, bx1)
        overlap_right = min(ax2, bx2)
        overlap_bottom = max(ay1, by1)
        overlap_top = min(ay2, by2)
        overlap_area = 0
        if overlap_left < overlap_right and overlap_bottom < overlap_top:
            overlap_area = (overlap_right - overlap_left) * (overlap_top - overlap_bottom)
        return area_a + area_b - overlap_area