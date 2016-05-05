/* Given a string, find the length of the longest substring without repeating characters. */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0; //abccake
        int max = 0;
        int start = 0;
        boolean repeatFound = false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                repeatFound = true;
                map.put(c, 2);
            } else {
                map.put(c, 1);
            }
            if (repeatFound) {
                max = Math.max(max, i - start);
                while (repeatFound) {
                    char startC = s.charAt(start);
                    int prevValue = map.get(startC);
                    if (prevValue == 2) {
                        // if this is the repeating character
                        map.put(startC, 1);
                        repeatFound = false;
                    } else {
                        map.remove(startC);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}
