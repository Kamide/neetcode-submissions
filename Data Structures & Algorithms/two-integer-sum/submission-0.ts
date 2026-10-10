class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums: number[], target: number): number[] {
        for (const pair of this.pairs(nums.length)) {
            if (nums[pair[0]] + nums[pair[1]] === target) {
                return pair;
            }
        }

        throw Symbol.for("unreachable");
    }

    *pairs(length: number) {
        for (let left = 0; left < length - 1; left += 1) {
            for (let right = left + 1; right < length; right += 1) {
                yield [left, right];
            }
        }
    }
}
