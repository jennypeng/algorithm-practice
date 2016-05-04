/* Given two strings, find the longest common subsequence and returns its length.
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4 */

// BRAINSTORM
// input is two strings
// output is a length of the longest substring

// algo: have a 2-D array where dp[i][j] = length of longest common subsequence ending at character i of the first string and j of the second
// dp[0][0] = 0
// dp[0][1...B.length] = 0;
// dp[1...A.length][0] = 0;
// ("G" & "GE") dp[i][j] = A.charAt(i - 1) == B.charAt(j - 1) ? 1 + dp[i - 1][j-1] :
// return dp[A.length()][B.length()]
// A.length() * B.length() runtime and space

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
      if (A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
      int[][] dp = new int[A.length() + 1][B.length() + 1];
      for (int i = 1; i <= A.length(); i++) {
        for (int j = 1; j <= B.length(); j++) {
          if (A.charAt(i - 1) == B.charAt(j - 1)) {
            dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j-1]);
          }
          dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
          dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
        }
      }
      return dp[A.length()][B.length()];
    }
}
