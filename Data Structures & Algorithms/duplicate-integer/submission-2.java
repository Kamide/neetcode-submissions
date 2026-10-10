class Solution {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().distinct().count() != nums.length;
    }
}
