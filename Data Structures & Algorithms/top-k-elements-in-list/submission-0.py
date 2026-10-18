from collections import defaultdict


class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        frequency = defaultdict(int)

        for num in nums:
            frequency[num] += 1

        ranked = sorted(
            frequency.items(),
            key=lambda item: item[1],
            reverse=True
        )

        return [num for num, count in ranked[:k]]
