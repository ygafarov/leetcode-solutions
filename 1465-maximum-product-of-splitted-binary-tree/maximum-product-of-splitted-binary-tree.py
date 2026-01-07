
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        MOD = 1_000_000_000 + 7
        prefix_sum_map: dict[TreeNode, int] = {}
        self.prefixSum(prefix_sum_map, root)
        max_mult = 0
        for key in prefix_sum_map:
            first = prefix_sum_map[key]
            second = prefix_sum_map[root] - prefix_sum_map[key]
            max_mult = max(max_mult, first * second)
        return max_mult % MOD

    def prefixSum(self, prefix_sum_map: dict[TreeNode, int], node: Optional[TreeNode]):
        if node is None:
            return 0

        if node in prefix_sum_map:
            return prefix_sum_map[node]

        prefix_sum_map[node] = node.val + self.prefixSum(prefix_sum_map, node.left) + self.prefixSum(prefix_sum_map,
                                                                                                     node.right)
        return prefix_sum_map[node]