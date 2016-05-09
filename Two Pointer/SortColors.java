/* Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

*/

public class Solution {
    public void sortColors(int[] nums) {
      int start = 0;
      int end = nums.length;
      for (int i = 0; i < nums.length; i++) {
        int currColor = nums[i];
        if (currColor == 0) {
          start ++;
        } else if (currColor == 2) {
          end--;
        } else {
          continue;
        }
      }
      for (int i = 0; i < start; i++) { nums[i] = 0; }
      for (int i = start; i < end; i++) { nums[i] = 1; }
      for (int i = end; i < nums.length; i++) { nums[i] = 2; }

    }
}
