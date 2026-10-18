class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product_sans_zeros = 1
        zeros = 0

        for num in nums:
            if num == 0:
                zeros += 1

                if zeros > 1:
                    return [0] * len(nums)
            else:
                product_sans_zeros *= num

        if zeros == 1:
            return [
                product_sans_zeros if num == 0 else 0
                for num in nums
            ]

        return [
            product_sans_zeros // num
            for num in nums
        ]
