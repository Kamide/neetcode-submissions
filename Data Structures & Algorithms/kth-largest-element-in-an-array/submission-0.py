from heapq import heappush as heap_push, heapreplace as heap_replace


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []

        for num in nums:
            if len(min_heap) < k:
                heap_push(min_heap, num)
            elif num > min_heap[0]:
                heap_replace(min_heap, num)

        return min_heap[0]
