/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.*/

// BRAINSTORM
// input two integers n and k where k is the length of the combinations
// output should be list of combinations where each combo is a list
//algo: initialize a tmp list and add the empty combination to it
// then for each value 1..n add to each combo in tmp
// if size == k add to result list
// 2^n runtime since generating all combos

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
      ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
      ArrayList<Integer> combo = new ArrayList<Integer>();
      combine(result, combo, 1, n, k);
      return result;
    }
    public void combine(ArrayList<List<Integer>> combos, ArrayList<Integer> combo, int start, int end, int k) {
      if (k == 0) {
        combos.add(new ArrayList<Integer>(combo));
      } else {
        for (int i = start; i <= end;  i++) {
          combo.add(i);
          combine(combos, combo, i + 1, end, k - 1);
          combo.remove(combo.size() - 1);
        }
      }
    }
}
