class Solution {
    maxSubArray(nums: number[]) {
        let current = nums[0];
        let largest = current;

        for (let i = 1; i < nums.length; i += 1) {
            current = Math.max(nums[i], current + nums[i]);
            largest = Math.max(current, largest);
        }

        return largest;
    }
}
