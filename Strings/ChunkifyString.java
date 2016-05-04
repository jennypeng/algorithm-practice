/* Given a character limit and a message, split the message up into annotated chunks without cutting words as, for example when sending the SMS "Hi Sivasrinivas, your Uber is arriving now!" with char limit 25, you should get
["Hi Sivasrinivas,(1/3)", "your Uber is arriving(2/3)", "now!(3/3)"]

*/

// BRAINSTORM
// input is string with max character limit
// output array of strings

public class Solution {
  public ArrayList<String> chunkifyString(String msg, int max) {
    int i = 0;
    ArrayList<String> result = new ArrayList<String>();
    while (i < msg.length()) {
      int endIndex = i + max;
      if (endIndex > msg.length()) {
        result.add(msg.substring(i));
        return result;
      } else {
        while (msg.charAt(endIndex) != ' ') endIndex--;
        result.add(msg.substring(i, endIndex));
        i = endIndex + 1;
      }
    }
    return result;
  }
}
