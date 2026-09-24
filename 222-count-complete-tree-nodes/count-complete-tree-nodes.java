class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (left == right) {
            return (1 << left) + countNodes(root.right);
        } else {
            return (1 << right) + countNodes(root.left);
        }
    }

    int height(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }
}