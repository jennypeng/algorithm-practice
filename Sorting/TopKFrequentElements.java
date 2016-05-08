/* Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

// BRAINSTORM:
// input is an unsorted array of integers
// output is an array of size k

// algo: nlogn algo is create nodes for each value which contain the number of times seen before, and then put them in a priority queue and pop k

// but we are asking for an algorithm with better than nlogn, which means a liner time solution.

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> topK = new ArrayList<Integer>();
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        LinkedList<Integer>[] buckets = new LinkedList[nums.length + 1];
        for (int num : nums) {
          countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // now we have counted all the values
        for (int key : countMap.keySet()) {
          int count = countMap.get(key);
          if (buckets[count] == null) {
            buckets[count] = new LinkedList<Integer>();
          }
          buckets[count].add(key);
        }
        for (int i = buckets.length - 1; i >= 0; i--) {
          LinkedList<Integer> currBucket = buckets[i];
          if (currBucket != null) {
            for (int num : currBucket) {
              topK.add(num);
              if (topK.size() == k) return topK;
            }
          }
        }
        return topK;

    }
}
