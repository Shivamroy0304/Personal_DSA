class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Get maximum contribution from left and right
        // Ignore negative contributions
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));

        // Complete path passing through current node
        int currentPath = left + root.val + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Parent can use only one branch
        return root.val + Math.max(left, right);
    }
}