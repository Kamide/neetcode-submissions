class Solution:
    def threeSum(self, nums: list[int]) -> list[tuple[int, int, int]]:
        nums = sorted(nums)
        length = len(nums)
        sums = []

        for index in range(length - 2):
            if index > 0 and nums[index] == nums[index - 1]:
                continue

            left = index + 1
            right = length - 1

            while left < right:
                sum_ = nums[index] + nums[left] + nums[right]

                if sum_ < 0:
                    left += 1
                elif sum_ > 0:
                    right -= 1
                else:
                    sums.append((nums[index], nums[left], nums[right]))

                    left += 1
                    right -= 1

                    while left < right and nums[left] == nums[left - 1]:
                        left += 1

                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1

        return sums
