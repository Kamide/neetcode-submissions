class Solution {
    public int[] twoSum(final int[] numbers, final int target) {
        var left = 0;
        var right = numbers.length - 1;

        while (left < right) {
            final var sum = numbers[left] + numbers[right];

            switch (Integer.compare(sum, target)) {
                case -1 -> left += 1;
                case 1 -> right -= 1;
                case 0 -> {
                    return new int[] {left + 1, right + 1};
                }
            }
        }

        return new int[] {0, 0};
    }
}
