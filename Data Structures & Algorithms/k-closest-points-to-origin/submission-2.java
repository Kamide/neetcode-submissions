class Solution {
    public int[][] kClosest(final int[][] points, final int k) {
        final var farthest = new PriorityQueue<int[]>(
            (a, b) -> Long.compare(
                distanceSquared(b),
                distanceSquared(a)));

        for (final var point : points) {
            farthest.offer(point);

            if (farthest.size() > k) {
                farthest.poll();
            }
        }

        final var closest = new int[k][];

        for (var i = 0; i < k; i += 1) {
            closest[i] = farthest.poll();
        }

        return closest;
    }

    private long distanceSquared(final int[] point) {
        final var x = (long) point[0];
        final var y = (long) point[1];

        return x * x + y * y;
    }
}
