class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        flag = 0

        for num in nums:
            flag ^= num

        return flag
