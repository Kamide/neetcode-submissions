class Solution {
    longestConsecutive(nums: number[]): number {
        let longest = 0;
        const numSet = new Set(nums);

        for (const num of numSet) {
            if (numSet.has(num - 1)) {
                continue;
            }

            const start = num;
            let end = start + 1;

            while (numSet.has(end)) {
                end += 1;
            }

            longest = Math.max(longest, end - start);
        }

        return longest;
    }
}
