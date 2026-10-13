class Solution:
    def reverseBits(self, n: int) -> int:
        reversed = 0

        for _ in range(32):
            reversed = (reversed << 1) | (n & 1)
            n >>= 1

        return reversed
