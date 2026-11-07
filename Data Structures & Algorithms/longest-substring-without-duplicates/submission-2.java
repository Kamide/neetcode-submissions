final class Solution {
    public int lengthOfLongestSubstring(final String s) {
        var length = 0;
        final var lastSeenMap = new HashMap<Character, Integer>();

        for (int left = 0, right = 0; right < s.length(); right += 1) {
            final var c = s.charAt(right);
            final var lastSeen = lastSeenMap.getOrDefault(c, -1);

            if (lastSeen >= left) {
                left = lastSeen + 1;
            }

            lastSeenMap.put(c, right);
            length = Math.max(length, right - left + 1);
        }

        return length;
    }
}
