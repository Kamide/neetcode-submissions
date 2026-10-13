class Solution:
    def countBits(self, n: int) -> List[int]:
        size = n + 1
        popcount = [0] * size

        for i in range(1, size):
            popcount[i] = 1 + popcount[i & (i - 1)]

        return popcount
