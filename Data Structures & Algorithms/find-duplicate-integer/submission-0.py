class Solution:
    def findDuplicate(self, nums: list[int]) -> int:
        seen: set[int] = set()

        for num in nums:
            if num in seen:
                return num

            seen.add(num)
