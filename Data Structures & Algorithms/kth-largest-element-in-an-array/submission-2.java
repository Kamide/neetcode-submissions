class Solution {
    public int findKthLargest(final int[] nums, final int k) {
        final var minHeap = new PriorityQueue<Integer>();

        for (final var num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }

        return minHeap.peek();
    }
}
