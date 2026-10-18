class Solution {
    topKFrequent(nums: number[], k: number): number[] {
        const frequency: Record<number, number> = Object.create(null);

        for (const num of nums) {
            frequency[num] ??= 0;
            frequency[num] += 1;
        }

        return Object.entries(frequency)
            .sort((a, b) => b[1] - a[1])
            .slice(0, k)
            .map(([num]) => Number(num));
    }
}
