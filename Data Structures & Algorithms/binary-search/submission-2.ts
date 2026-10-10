class Solution {
  search(nums: number[], target: number): number {
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
      const mid = left + Math.trunc((right - left) / 2);
      const num = nums[mid];

      if (num === target) {
        return mid;
      }

      if (num < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
}
