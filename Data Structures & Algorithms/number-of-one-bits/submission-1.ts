class Solution {
    hammingWeight(n: number): number {
        let popcount = 0;

        while (n) {
            n &= n - 1;
            popcount += 1;
        }

        return popcount;
    }
}
