/* Implement a heap. */

public class BinaryHeap {
  // number of children each node has
  private static final int d = 2;
  private int heapSize;
  private int[] heap;

  // constructor
  public BinaryHeap(int capacity) {
    this.heapSize = 0;
    heap = new int[capacity + 1];
    Arrays.fill(heap, -1);
  }

  // check if heap is empty
  public boolean isEmpty() {
    return heapSize == 0;
  }

  public boolean isFull() {
    return heapSize == heap.length;
  }

  public void makeEmpty() {
    heapSize = 0;
  }
  // return parent of i
  private int parent(int i) {
    return (i - 1)/d;
  }
  private int kthChild(int i, int k) {
    return i * d + k;
  }

  // when you insert you want to put it at the end and then bubble up to its correct location
  public void insert(int x) {
    if (isFull()) throw new NoSuchElementException("Overflow");
    heap[heapSize++] = x;
    heapifyUp(heapSize - 1)
  }
  public int findMin() {
    if (isEmpty()) throw new NoSuchElementException("Underflow");
    return heap[0]; // the value at the top will be the smallest because it is a min heap
  }
  public int deleteMin() {
    // get the value from the bottom
    int keyItem = heap[0];
    delete(0);
    return keyItem;
  }

  public int delete(int ind) {
    if (isEmpty()) throw new NoSuchElementException("underflow");
    int keyItem = heap[ind];
    heap[ind] = heap[heapSize - 1];
    heapSize--;
    heapifyDown(ind);
    return keyItem;
  }
  public void heapifyUp(int childInd) {
    int child;
    int tmp = heap[childInd];
    while (childInd > 0 && tmp < heap[parent(childInd)]) {
      heap[childInd] = heap[parent(childInd)];
      childInd = parent(childInd);
    }
    heap[childInd] = tmp;
  }

  public void heapifyDown(int childInd) {
    int child;
    int tmp = heap[childInd];
    while (kthChild(ind, 1) < heapSize) {
      child = minChild(ind);
      if (heap[child] < tmp) {
        heap[childInd] = heap[child];
      } else {
        break;
      }
      childInd = child;
    }
    heap[childInd] = tmp;
  }
  public int minChild(int ind) {
    int bestChild = kthChild(ind, 1);
    int k = 2;
    int pos = kthChild(ind, k);
    while ((k <= d) && (pos < heapSize)) {
      if (heap[pos] < heap[bestChild]) bestChild = post;
      post = kthChild(ind, k++);
    }
    return bestChild;
  }
}
