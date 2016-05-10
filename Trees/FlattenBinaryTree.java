/* Given a binary tree, flatten it to a linked list in-place. */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public void flatten(TreeNode root) {
      if (root == null) return;
      TreeNode right = root.right;
      TreeNode left = root.left;
      flatten(right);
      flatten(left);
      root.right = left;
      root.left = null;
      while (root.right != null) root = root.right;
      root.right = right;
    }
}
