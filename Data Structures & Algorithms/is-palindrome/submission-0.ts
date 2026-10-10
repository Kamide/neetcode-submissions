const alphanumeric = new Set("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");

class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s: string): boolean {
        let i = 0;
        let j = s.length - 1;

        while (i < j) {
            const x = s[i];
            const y = s[j];

            if (!alphanumeric.has(x)) {
                i += 1;
                continue;
            }

            if (!alphanumeric.has(y)) {
                j -= 1;
                continue;
            }

            if (x.toLowerCase() !== y.toLowerCase()) {
                return false;
            }

            i += 1;
            j -= 1;
        }

        return true;
    }
}
