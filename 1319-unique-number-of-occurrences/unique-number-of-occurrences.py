class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        count=Counter(arr)
        met=set()
        for key, val in count.items():
            if val in met:
                return False
            met.add(val)
        return True