/* Given two strings, find the longest common substring and returns its length.
For example, if the given strings are “GeeksforGeeks” and “GeeksQuiz”, the output should be 5 as longest common substring is “Geeks” */

// BRAINSTORM
// input is two strings
// output is a length of the longest substring

// algo: have a 2-D array where dp[i][j] = length of longest common subsequence ending at character i of the first string and j of the second
// dp[0][0] = 0
// dp[0][1...B.length] = 0;
// dp[1...A.length][0] = 0;
// ("G" & "GE") dp[i][j] = A.charAt(i - 1) == B.charAt(j - 1) ? 1 + dp[i - 1][j-1] : 0
// keep track of a max;

// A.length() * B.length() runtime and space

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
        int max = 0;
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
          for (int j = 1; j <= B.length(); j++) {
            dp[i][j] = A.charAt(i - 1) == B.charAt(j - 1)? 1 + dp[i-1][j-1] : 0;
            max = Math.max(dp[i][j], max);
          }
        }
        return max;
    }
}
