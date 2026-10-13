class Solution {
    public int singleNumber(int[] nums) {
        var flag = 0;

        for (var num : nums) {
            flag ^= num;
        }

        return flag;
    }
}
