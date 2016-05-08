/* Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. */

// BRAINSTORM!
// input is a string of mismatched parenthesis
// output is an integer of the longest matched parenthesis

// algo: usually with parenthesis, we want to use some kind of stack so when we encounter a close paren, we can pop
// the stack to see if it matches

// in this case we want to find the longest valid matching

// with each parenthesis, we want to store its index so we can keep track of which indices span invalid/valid parenthesis

// so algo is: push index on if its an open brace and pop if its a close brace. indices left after we go through entire string
// are the mismatched ones. use this to find longest valid.

public class Solution {
    public int longestValidParentheses(String s) {
      Stack<Parenthesis> stack = new Stack<Parenthesis>();
      for (int i = 0; i < s.length(); i++) {
        char currParen = s.charAt(i);
        if (currParen == '(') {
          stack.push(new Parenthesis(false, i));
        } else { // it is a closing parenthesis
          if (stack.isEmpty()) {
              stack.push(new Parenthesis(true, i));
              continue;
          }
          boolean closed = stack.peek().close;
          if (!closed) {
            stack.pop();
          } else { // if the parenthesis doesn't match, we push it on
            stack.push(new Parenthesis(true, i));
          }
        }
      }

      // now process the elements left in the stack
      if (stack.isEmpty()) return s.length();
      int max = 0;
      int prevIndex = s.length();
      while (!stack.isEmpty()) {
        int currIndex = stack.pop().index;
        max = Math.max(max, prevIndex - currIndex - 1);
        prevIndex = currIndex;
      }
      max = Math.max(max, prevIndex); // )()() max is 4, 0
      return max;
    }
    class Parenthesis {
      boolean close;
      int index;
      public Parenthesis(boolean close, int index) {
        this.close = close;
        this.index = index;
      }
    }
}
