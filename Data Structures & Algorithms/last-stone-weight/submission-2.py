from heapq import heapify_max, heappop_max, heappush_max


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heapify_max(stones)

        while len(stones) >= 2:
            heaviest = heappop_max(stones)
            second_heaviest = heappop_max(stones)
            remaining_weight = heaviest - second_heaviest

            if remaining_weight > 0:
                heappush_max(stones, remaining_weight)

        try:
            return stones[0]
        except IndexError:
            return 0
