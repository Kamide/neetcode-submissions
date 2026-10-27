class Solution {
    reverse(x: number): number {
        let reversed = 0;

        while (x !== 0) {
            const digit = x % 10;
            x = Math.trunc(x / 10);

            reversed *= 10;
            reversed += digit;

            if (reversed < -(2 ** 31) || reversed > 2 ** 31 - 1) {
                return 0;
            }
        }

        return reversed;
    }
}
