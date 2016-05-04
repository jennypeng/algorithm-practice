/* Given an array, find the nearest smaller element G[i] for every element A[i] in the array
such that the element has an index smaller than i. */

// BRAINSTORM:
// input: unsorted array of integers
// output: array of integers representing nearest smaller element

// algo: iterate through each element in nums with each element as x:
// for each x pop larger values until you reach a smaller value.
// set smaller value in the result array.
// push x onto stack
// repeat
// linear time and space

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      Stack<Integer> stack = new Stack<Integer>();
      if (arr == null || arr.size() == 0) return result;
      for (int i = 0; i < arr.size(); i++) {
        int currVal = arr.get(i);
        while (!stack.isEmpty() && stack.peek() >= currVal) stack.pop();
        if (stack.isEmpty()) {
          result.add(-1);
        } else {
          int nearestSmaller = stack.peek();
          result.add(nearestSmaller);
        }
        stack.push(currVal);
      }
      return result;
    }
}

