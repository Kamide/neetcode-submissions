class Solution {
    singleNumber(nums: number[]): number {
        let flag = 0;

        for (const num of nums) {
            flag ^= num;
        }

        return flag;
    }
}
