from heapq import heappush as heap_push, heapreplace as heap_replace


class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.capacity = k
        self.min_heap = []

        for num in nums:
            self.add(num)

    def add(self, val: int) -> int:
        if self.size < self.capacity:
            heap_push(self.min_heap, val)
        elif val > self.min:
            heap_replace(self.min_heap, val)

        return self.min

    @property
    def size(self) -> int:
        return len(self.min_heap)

    @property
    def min(self) -> int:
        return self.min_heap[0]
