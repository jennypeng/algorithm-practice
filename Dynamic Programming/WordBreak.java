/* Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". */

// BRAINSTORM

// input: string and dictionary
// output boolean of whether it can be segmented or not

// algo: have int[] where dp[i] = true if the string up to point i can be segmented, then dp[string.length()] is the answer

// l = false
// le = false
// lee = false
// leet = true
// leet c = false;
// leet co = false
// leet cod = false;
// leet code = true;


public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
      if (s.equals("") || wordDict.size() == 0) return false;
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
      for (int i = 1; i <= s.length(); i++) {
        for (int j = i; j >= 0; j--) {
            if (dp[j] && wordDict.contains(s.substring(j, i))) {
              dp[i] = true;
              break;
            }
        }
      }
      return dp[s.length()];

    }
}
