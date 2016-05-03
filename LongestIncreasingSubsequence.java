/* Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity? */

// BRAINSTORM:
// input: unsorted array of integers.
// output length of longest increasing subsequence

// use dp with 1-D array where dp[i] = minimum value a subsequence of length i _ 1 might end with

public class Solution {
    public int lengthOfLIS(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int[] dp = new int[nums.length];
      int len = 0;
      for (int i = 0; i < nums.length; i++) {
        int searchResult = Arrays.binarySearch(dp, 0, len, nums[i]);

        if (searchResult < 0) searchResult = -(searchResult + 1);
        dp[searchResult] = nums[i];
        if (searchResult == len) len++;

      }
    return len;
  }
}
