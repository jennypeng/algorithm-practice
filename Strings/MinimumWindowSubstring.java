/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.*/

// algo: increment all values of t into a map to represent which values must be found.
// traverse string s, decrementing all values from the map.
// if a value in a key in the map is positive, we know it was a value from t, so we decrement chars left to find
// once chars left to find is 0, we know we have found a possible window.
// we iterate start and keep track of minimum len and min start for that window (in case values from start to the first char in t are useless)
// then if we find a key where its value in map is positive, we know it was in t, so we decrease charsLeft to find and exit the loop
public class Solution {
  public String minWindow(String s, String t) {

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    // increment for chars in t
    for (int i = 0; i < t.length(); i++) {
      if (map.get(t.charAt(i)) == null ) {
          map.put(t.charAt(i), 1);
      } else {
          map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
      }
    }

    int start = 0;
    int end = 0;
    int charsLeft = t.length();
    int minStart = 0;
    int minLen = Integer.MAX_VALUE;

    // loop to find a window
    while (end < s.length()) {
      int charCount = map.get(s.charAt(end)) == null? 0 : map.get(s.charAt(end));

      if (charCount > 0) { // we encountered a character in t
        charsLeft--; // decrement characters left to look for
      }

      map.put(s.charAt(end), charCount - 1);
      end++; // go to the next character

      // found a window!
      while (charsLeft == 0) {
        if (end - start < minLen) {
          minLen = end - start;
          minStart = start;
        }
        // move start one ahead;
        map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
        if (map.get(s.charAt(start)) > 0) { // its in T
          charsLeft++;
        }
        start++;

      }
    }
    if (minLen != Integer.MAX_VALUE) return s.substring(minStart, minLen + minStart);
    return "";
  }
}
