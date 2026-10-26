class MedianFinder {
    private final PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> upperHalf = new PriorityQueue<>();

    public void addNum(final int num) {
        lowerHalf.offer(num);
        upperHalf.offer(lowerHalf.poll());

        if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.isEmpty()) {
            return Double.NaN;
        }

        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        }

        return ((long) lowerHalf.peek() + upperHalf.peek()) / 2.0;
    }
}
