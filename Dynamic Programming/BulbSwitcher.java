/* There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3.

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off].

So you should return 1, because there is only one bulb is on. */

// BRAIN STORM

// input is an integer
// output is an integer representing how many bulbs are on

// base case is n = 1, you have one on [on]
// n = 2, [off, off] -> 1) [on, on] 2) [on, off]
// n = 3  [on, off, off]
// n = 4 [on, on, on, on] -> [on, off, on, off] -> [on, off, off, off] -> [on, off, off, on]
// for whatever n, it is dependent on the n - 1 case,
// for case n, we have case[n] +

// DOESN'T WORK FOR LARGE CASES!! MUST FIND A WAY TO DO WITHOUT SPACE
// public class Solution {
//     public int bulbSwitch(int n) {
//       int[] bulbs = new int[n];
//       int total = 1;
//       if (n == 0) return 0;
//       bulbs[0] = 1;
//       if (n == 1) return 1;
//       for (int i = 1 ; i < n; i++) {
//         int prevIndex = i / 2;
//         bulbs[i] = bulbs[prevIndex] ^ 1;
//         total += bulbs[i];
//       }
//       return total;

//     }
// }

public class Solution {
    public int bulbSwitch(int n) {
      return (int) Math.floor(Math.sqrt(n));
    }
}
