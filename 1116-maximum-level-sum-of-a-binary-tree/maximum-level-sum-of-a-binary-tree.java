class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int optLevel = 0;
        int currentLevel = 0;
        while (!q.isEmpty()) {
            currentLevel++;
            int qSize = q.size();
            int currentSum = 0;
            for (int i = 1; i <= qSize; i++) {
                TreeNode treeNode = q.poll();
                currentSum += treeNode.val;
                if (treeNode.left != null)
                    q.offer(treeNode.left);
                if (treeNode.right != null)
                    q.offer(treeNode.right);
            }
            if (currentSum > maxSum) {
                maxSum = Math.max(maxSum, currentSum);
                optLevel = currentLevel;
            }

        }
        return optLevel;
    }
}