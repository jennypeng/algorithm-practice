/* Given a string, find the longest substring that contains only two unique characters.
For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb". */

// algo: first find a substring of two distinct characters, then adjust start until we have less than two distnct.
public int lengthOfLongestSubstringTwoDistinct(String s) {
  if (s == null || s.length() = 0) return 0
  HashMap<Character, Integer> map = new HashMap<Character, Integer>();
  int start = 0;
  int max = 0;
  for (int i = 0; i < s.length(); i++) {
    char curr = s.charAt(i);
    if (map.containsKey(curr)) {
      map.put(curr, map.get(curr) + 1);
    } else {
      map.put(curr, 1);
    }
    if (map.size() > 2) {
      max = Math.max(max, i - start);
      while (map.size() > 2) {
        char currStart = map.get(start);
        if (map.get(currStart) > 1) {
          map.put(currStart, map.get(currStart) - 1);
        } else {
          map.remove(currStart);
        }
        start++;
      }
    }
  }
  max = Math.max(max, s.length() - start); // get the last one
  return max;

}
