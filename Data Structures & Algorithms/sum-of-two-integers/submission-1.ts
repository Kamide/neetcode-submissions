class Solution {
    getSum(a: number, b: number): number {
        if (b === 0) {
            return a;
        }

        return this.getSum(a ^ b, (a & b) << 1);
    }
}
