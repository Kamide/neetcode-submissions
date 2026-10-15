function* subsetsOf(nums: number[]) {
    if (nums.length === 0) {
        yield [];
        return;
    }

    const first = nums[0];

    for (const subset of subsetsOf(nums.slice(1))) {
        yield subset;
        yield [first, ...subset];
    }
}

class Solution {
    subsets = (nums: number[]) => [...subsetsOf(nums)];
}
