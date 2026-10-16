class Solution {
    public int maxSubArray(int[] nums) {
        var current = nums[0];
        var largest = current;

        for (var i = 1; i < nums.length; i += 1) {
            current = Math.max(nums[i], current + nums[i]);
            largest = Math.max(current, largest);
        }

        return largest;
    }
}
