/*Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint. */

// BRAINSTORM:
// input is an array of n positive numbers and positive integer s
// output minimal length of which sum >= s, default to 0

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int min = Integer.MAX_VALUE;
      int currSum = 0;
      int start = 0;
      for (int i = 0; i < nums.length; i++) {
        int currNum = nums[i];
        currSum += currNum;

        while (currSum >= s) {
          min = Math.min(min, i - start + 1);
          currSum -= nums[start];
          start++;
        }
      }
      if (min == Integer.MAX_VALUE) return 0;
      return min;
    }
}
