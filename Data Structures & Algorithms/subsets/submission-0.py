def subsets_of(nums: List[int]) -> Iterator[List[int]]:
    if not nums:
        yield []
        return

    first = nums[0]

    for subset in subsets_of(nums[1:]):
        yield subset
        yield [first] + subset


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        return list(subsets_of(nums))
