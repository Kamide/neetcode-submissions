class Solution {
    public List<List<Integer>> threeSum(final int[] numbers) {
        final var sorted = Arrays
            .stream(numbers)
            .sorted()
            .toArray();

        final var length = sorted.length;
        final var triplets = new ArrayList<List<Integer>>();

        for (
            var index = 0;
            index < length - 2 && sorted[index] <= 0;
            index += 1
        ) {
            if (index > 0 && sorted[index] == sorted[index - 1]) {
                continue;
            }

            var left = index + 1;
            var right = length - 1;

            while (left < right) {
                final var triplet = List.of(
                    sorted[index],
                    sorted[left],
                    sorted[right]
                );

                switch (Integer.compare(sum(triplet), 0)) {
                    case -1 -> left += 1;
                    case 1 -> right -= 1;
                    case 0 -> {
                        triplets.add(triplet);

                        left += 1;
                        right -= 1;

                        while (left < right && sorted[left] == sorted[left - 1]) {
                            left += 1;
                        }

                        while (left < right && sorted[right] == sorted[right + 1]) {
                            right -= 1;
                        }
                    }
                }
            }
        }

        return triplets;
    }

    private int sum(final List<Integer> triplet) {
        return triplet
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
