class Solution {
    public int reverse(int x) {
        var reversed = 0;

        while (x != 0) {
            final var digit = x % 10;
            x /= 10;

            if (
                reversed >   214748364
            || (reversed ==  214748364 && digit >  7)
            ||  reversed <  -214748364
            || (reversed == -214748364 && digit < -8)
            ) {
                return 0;
            }

            reversed *= 10;
            reversed += digit;
        }

        return reversed;
    }
}
