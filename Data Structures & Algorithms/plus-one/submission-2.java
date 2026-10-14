class Solution {
    public int[] plusOne(int[] digits) {
        for (var i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        var sum = new int[digits.length + 1];
        sum[0] = 1;
        return sum;
    }
}
