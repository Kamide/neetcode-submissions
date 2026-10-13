class Solution {
    public int lastStoneWeight(int[] stones) {
        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (var stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            var heaviest = maxHeap.poll();
            var secondHeaviest = maxHeap.poll();
            var remainingWeight = heaviest - secondHeaviest;

            if (remainingWeight > 0) {
                maxHeap.add(remainingWeight);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
