/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. */

// BRAINSTORM:
// input: array of unsorted integers
// output: sorted array of consecutive integers.

// should be linear runtime so maybe one pass or two pass algo.

// naive implementation: sort the array, and then iterate for nlogn

// bad algo: iterate through the array keep track of max and min and push values to a hashset. Then iterate through hashset starting from min to max

// better algo: use hashmap and put in values, check if left (n-1) and right (n + 1) values in. then lenghth would be map(n-1) + 1 + map(n + 1)

// put in 100: no 99 or 101, so map[100] = 1;
// put in 4: no 3 or 5, so map[4] = 1;
// put in 200, map[200] = 1;
// put in 1, map[1] = 1;
// put in 3, map[2] = 0, map [4] = 1; map[3] = 0 + 1 + 1 = 2, map[4] = 2;
// put in 2, map[1] = 1, map [2] = 1, map[3] = 2 = 4

public class Solution {
    public int longestConsecutive(int[] nums) {
      int max = 0;
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < nums.length; i++) {
        int value = nums[i];
        if (map.get(value) == null) {
          int left = map.containsKey(value - 1)? map.get(value - 1) : 0;
          int right = map.containsKey(value + 1)? map.get(value + 1) : 0;
          map.put(value, left + right + 1);
          if (left != 0) map.put(value - left, left + right + 1);
          if (right != 0) map.put(value + right, left + right + 1);
          max = Math.max(max, left + right + 1);
        }
      }
      return max;
    }
}
