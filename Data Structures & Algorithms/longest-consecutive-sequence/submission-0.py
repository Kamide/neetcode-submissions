class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        longest = 0
        num_set = set(nums)

        for num in num_set:
            if num - 1 not in num_set:
                start = num
                end = start + 1

                while end in num_set:
                    end += 1

                longest = max(longest, end - start)

        return longest
