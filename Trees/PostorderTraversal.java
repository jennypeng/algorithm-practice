/* Given a binary tree, return the postorder traversal of its nodes' values.*/
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
    public List<Integer> postorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode currNode = root;
      while (currNode != null || !stack.isEmpty()) {
        while (currNode != null) {
          stack.add(currNode);
          result.add(0, currNode.val);
          currNode = currNode.right;
        } // else find the right
        currNode = stack.pop();
        currNode = currNode.left;
      }
      return result;

    }
}
