/* Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.

The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

*/

// BRAINSTORM

// input is a binary tree
// output is an integer with the maximum path sum

//     - 30
//      5  10
//    3  6 7  9

// algo would look something like:
// for the root:
// max path sum of root = Math.max(maxPathSum(root.left), maxPathSum(root.right), maxOnePath(root.left) + maxOnePath(root.right) + root.val)
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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      if (root == null) return 0;
      maxOnePathSum(root);
      return maxSum;

    }
    public int maxOnePathSum(TreeNode root) {
      if (root == null) return 0;
      // max path is either left or right
      int left = Math.max(0, maxOnePathSum(root.left));
      int right = Math.max(0, maxOnePathSum(root.right));
      maxSum = Math.max(maxSum, left + right + root.val);
      return Math.max(left, right) + root.val;
    }
}

