class Solution {
    countBits(n: number): number[] {
        const popcount = new Array(n + 1);
        popcount[0] = 0;

        for (let i = 1; i <= n; i += 1) {
            popcount[i] = 1 + popcount[i & (i - 1)];
        }

        return popcount;
    }
}
