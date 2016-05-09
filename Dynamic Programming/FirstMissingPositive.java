/* Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.*/

// BRAINSTORM:
// negative numbers have no effect at all, so [3, 4, -1, 1] -> [3, 4, 1]
// continuly swap numbers to the correct place so that we can iterate through it at the end and find the first incorrect place
public class Solution {
    public int firstMissingPositive(int[] nums) {
      if (nums == null || nums.length == 0) return 1;
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
            swap(i, nums[i] - 1, nums);
        }
      }
      int lastPositive = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) return i + 1;
      }
      return nums.length + 1;
    }

    public void swap(int a, int b, int[] nums) {
      int tmp = nums[a];
      nums[a] = nums[b];
      nums[b] = tmp;
    }
}
