/* Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

*/
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
      boolean[] visited = new boolean[wordList.size()];
      Queue<String> queue = new Queue<String>();
      if (beginWord == null || beginWord == "") return 0;
      int count = 2;
      queue.offer(beginWord);
      wordList.put(endWord);
      while (!queue.isEmpty()) {
        int size = queue.size();
        count++;
        for (int i = 0; i < size; i++) {
          String popped = queue.poll();
          if (popped.equals(endWord)) return count;
          for (int j = 0; j < wordList.size(); j++) {
            if (visited[j]) continue;
            // check if differ by only one letter
            int differ = 0;
            for (int x = 0; x < popped.length(); x++) {
              if (x >= wordList.get(j).length()) continue;
              if (popped.charAt(x) != wordList.get(j).charAt(x)) differ++;
              if (differ > 1) break;
            }
            if (differ == 1) {
              visited[j] = true;
              queue.offer(wordList.get(j));
            }
          }
        }
      }
      return 0;
    }
}
