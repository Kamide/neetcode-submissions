type Triplet = [number, number, number];

class Solution {
    threeSum(nums: number[]): Triplet[] {
        nums = [...nums].sort((a, b) => a - b);
        const length = nums.length;
        const sums: Triplet[] = [];

        for (let index = 0; index < length - 2 && nums[index] <= 0; index += 1) {
            if (index > 0 && nums[index] === nums[index - 1]) {
                continue;
            }

            let left = index + 1;
            let right = length - 1;

            while (left < right) {
                const sum = nums[index] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    sums.push([nums[index], nums[left], nums[right]]);

                    left += 1;
                    right -= 1;

                    while (left < right && nums[left] === nums[left - 1]) {
                        left += 1;
                    }

                    while (left < right && nums[right] === nums[right + 1]) {
                        right -= 1;
                    }
                }
            }
        }

        return sums;
    }
}
