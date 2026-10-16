class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        current = largest = nums[0]

        for num in nums[1:]:
            current = max(num, current + num)
            largest = max(largest, current)

        return largest
