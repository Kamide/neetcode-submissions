class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        length = 0
        seen = set[str]()
        left = 0

        for right in range(len(s)):
            char = s[right]

            while char in seen:
                seen.remove(s[left])
                left += 1

            seen.add(char)
            length = max(length, right - left + 1)

        return length
