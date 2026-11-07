class Solution {
    lengthOfLongestSubstring(s: string): number {
        let length = 0;
        const lastSeenMap = new Map<string, number>();

        for (let left = 0, right = 0; right < s.length; right += 1) {
            const char = s[right];
            const lastSeen = lastSeenMap.get(char);

            if (lastSeen != null && lastSeen >= left) {
                left = lastSeen + 1;
            }

            lastSeenMap.set(char, right);
            length = Math.max(length, right - left + 1);
        }

        return length;
    }
}
