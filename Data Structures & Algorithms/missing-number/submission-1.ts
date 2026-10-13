class Solution {
    missingNumber(nums: number[]): number {
        let missing = nums.length;

        for (let i = 0, j = missing; i < j; i += 1) {
            missing ^= i ^ nums[i];
        }

        return missing;
    }
}
