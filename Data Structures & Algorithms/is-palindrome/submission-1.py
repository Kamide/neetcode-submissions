class Solution:
    def isPalindrome(self, s: str) -> bool:
        t = ''.join(c.casefold() for c in s if c.isalnum())
        return t[::-1] == t
