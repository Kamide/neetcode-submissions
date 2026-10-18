class Solution {
    public int longestConsecutive(final int[] nums) {
        var longest = 0;
        final var numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (final var num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }

            final var start = num;
            var end = start + 1;

            while (numSet.contains(end)) {
                end += 1;
            }

            longest = Math.max(longest, end - start);
        }

        return longest;
    }
}
