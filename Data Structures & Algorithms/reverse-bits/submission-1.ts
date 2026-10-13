class Solution {
    reverseBits(n: number): number {
        let reversed = 0;

        for (let bit = 0; bit < 32; bit += 1) {
            reversed = (reversed << 1) | (n & 1);
            n >>>= 1;
        }

        return reversed >>> 0;
    }
}
