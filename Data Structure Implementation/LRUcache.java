/* Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. */

// BRAINSTORM:
// have a hashmap underlying the data structure where key = (int key) and value = a DoubleLinkedNode which corresponds to that value.
// Use DoubleLinkedList so we can delete a node having knowledge of only itself in the case where we set something which is already in the cache.
// when we get or set something, we set it as a head.
// when its over capacity, we delete the end
public class LRUCache {
    private HashMap<Integer, DoubleLinkedNode> map = new HashMap<Integer, DoubleLinkedNode>();
    private int capacity;
    private DoubleLinkedNode head;
    private DoubleLinkedNode end;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
      if (map.get(key) == null) return -1;
      setHead(map.get(key));
      return map.get(key).value;

    }
    private void setHead(DoubleLinkedNode node) {
      if (node == end) {
        end = node.prev;
      }
      if (head == null) {
        head = node;
        end = node;
      } else {
        head.prev = node;
        head = node;
      }
    }
    private void deleteNode(DoubleLinkedNode node) {
      if (node == end) end = node.prev;
      DoubleLinkedNode tmpPrev = node.prev;
      node.prev.next = node.next;
      node.next.prev = tmpPrev;
    }

    public void set(int key, int value) {
      if (map.get(key) != null) {
        DoubleLinkedNode oldNode = map.get(key);
        deleteNode(oldNode);
      }
      DoubleLinkedNode node = new DoubleLinkedNode(value);
      map.put(key, node);
      setHead(node);
      // check if capacity is now over and if so, remove from cache
      if (map.size() > this.capacity) {
        // delete the oldest
        deleteNode(end);
      }
    }

    class DoubleLinkedNode {
      int value;
      DoubleLinkedNode next;
      DoubleLinkedNode prev;
      public DoubleLinkedNode(int value) {
        this.value = value;
      }
    }
}
