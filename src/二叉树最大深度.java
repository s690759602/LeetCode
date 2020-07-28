public class 二叉树最大深度 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private int ans;

        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            ans = 0;
            dfs(root, 1);
            return ans;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                ans = Math.max(depth, ans);
            } else {
                dfs(node.left, depth + 1);
                dfs(node.right, depth + 1);
            }
        }
    }
}
