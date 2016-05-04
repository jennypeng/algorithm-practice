/* Given an array, return the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array.
Elements for which no greater element exist, consider next greater element as -1.*/

// BRAINSTORM

// input: array of unsorted integers e. g. [4, 5, 2, 25]
// output: list of next greater for each element

// algo: push first value onto stack, then iterate through rest of elements comparing to the elements in the stack.
// runtime is linear since each item is pushed/popped off stack only once. space is linear.
public class Solution {
    public int[] nextGreater(int[] nums) {
      Stack<int[]> stack = new Stack<int[]>();
      int[] result = new int[nums.length];
      if (nums == null || nums.length == 0) return result;
      stack.push(new int[]{nums[0], 0});
      for (int i = 1; i < nums.length; i++) {
        int next = nums[i];
        while (!stack.isEmpty() && stack.peek()[0] < next) {
          result[stack.peek()[1]] = next;
          stack.pop();
        }
        stack.push(new int[]{next, i});
      }
      while (!stack.isEmpty()) {
        int index = stack.pop()[1];
        result[index] = -1;
      }
      return result;
    }
}
