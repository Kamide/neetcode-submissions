class Solution {
    private static final int START = 0;
    private static final int END = 1;

    public int[][] insert(final int[][] intervals, final int[] newInterval) {
        final var sorted = Stream
            .concat(Arrays.stream(intervals), Stream.of(newInterval))
            .sorted(Comparator.comparingInt(interval -> interval[START]));

        final var merged = new ArrayList<int[]>();

        for (final var iterator = sorted.iterator(); iterator.hasNext(); ) {
            final var interval = iterator.next();

            if (merged.isEmpty() ||
                merged.getLast()[END] < interval[START]) {
                merged.add(interval.clone());
            } else {
                final var last = merged.getLast();
                last[END] = Math.max(last[END], interval[END]);
            }
        }

        return merged.toArray(int[][]::new);
    }
}
