class Solution {
    public int[] twoSum(int[] nums, int target) {
        return IntStream.range(0, nums.length - 1)
                .boxed()
                .flatMap(left -> IntStream.range(left + 1, nums.length)
                        .filter(right -> nums[left] + nums[right] == target)
                        .mapToObj(right -> new int[]{left, right}))
                .findFirst()
                .orElseThrow();
    }
}
