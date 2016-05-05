/* Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination. */


// brainstorm, same as making combination, except if the sum of the values is larger than target, we don't add.

public class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    ArrayList<List<Integer>> combos = new ArrayList<List<Integer>>();
    combinationSum2(candidates, combos, new ArrayList<Integer>(), 0, target, 0);
    return combos;
  }

  public void combinationSum2(int[] candidates, ArrayList<List<Integer>> combos, ArrayList<Integer> combo, int start, int target, int sum) {
    if (sum == target) {
      combos.add(new ArrayList<Integer>(combo)); // add combo to combos
    } else if (start == candidates.length) {
        return;
    } else {
      for (int i = start; i < candidates.length; i++) {
        if (i > start && candidates[i] == candidates[i-1]) continue;
        int c = candidates[i];
        if (sum + c <= target) {
          combo.add(c);
          combinationSum2(candidates, combos, combo, i + 1, target, sum + c);
          combo.remove(combo.size() - 1);
        }
      }
    }
  }
}
