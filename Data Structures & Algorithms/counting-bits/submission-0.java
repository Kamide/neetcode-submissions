class Solution {
    public int[] countBits(int n) {
        var popcount = new int[n + 1];

        for (var i = 1; i <= n; i += 1) {
            popcount[i] = popcount[i >> 1] + (i & 1);
        }

        return popcount;
    }
}
