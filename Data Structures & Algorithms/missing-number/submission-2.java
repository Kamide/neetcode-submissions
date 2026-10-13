class Solution {
    public int missingNumber(int[] nums) {
        var missing = 0;

        for (var num = 0; num <= nums.length; num += 1) {
            missing ^= num;
        }

        for (var num : nums) {
            missing ^= num;
        }

        return missing;
    }
}
