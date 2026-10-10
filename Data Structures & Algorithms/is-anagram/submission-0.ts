class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s: string, t: string): boolean {
        if (s.length !== t.length) {
            return false;
        }

        const counts = new Map<string, number>();

        for (const c of s) {
            counts.set(c, (counts.get(c) ?? 0) + 1);
        }

        for (const c of t) {
            const count = counts.get(c);

            if (!count) {
                return false;
            }

            counts.set(c, count - 1);
        }

        return true;
    }
}
