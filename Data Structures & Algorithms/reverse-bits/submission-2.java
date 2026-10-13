class Solution {
    public int reverseBits(int n) {
        var reversed = 0;

        for (var bit = 0; bit < 32; bit += 1) {
            reversed = (reversed << 1) | (n & 1);
            n >>= 1;
        }

        return reversed;
    }
}
