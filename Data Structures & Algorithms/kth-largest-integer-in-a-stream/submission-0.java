class KthLargest {
    private final int capacity;
    private final Queue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        minHeap = new PriorityQueue<>(capacity);

        for (var num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < capacity) {
            minHeap.add(val);
        } else if (val > min()) {
            removeMin();
            minHeap.add(val);
        }

        return min();
    }

    private int min() {
        return minHeap.peek();
    }

    private void removeMin() {
        minHeap.poll();
    }
}
