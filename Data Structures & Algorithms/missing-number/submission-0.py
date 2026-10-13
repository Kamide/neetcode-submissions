class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        missing = 0

        for num in range(len(nums) + 1):
            missing ^= num

        for num in nums:
            missing ^= num

        return missing
