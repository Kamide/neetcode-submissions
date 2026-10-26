import heapq
from collections.abc import Callable


class Heap:
    def __init__(self, push: Callable[[list[int], int], None], pop: Callable[[list[int]], int]):
        self._heap: list[int] = []
        self._push = push
        self._pop = pop

    def push(self, num: int) -> None:
        self._push(self._heap, num)

    def pop(self) -> int:
        return self._pop(self._heap)

    def top(self) -> int:
        return self._heap[0]

    def __len__(self) -> int:
        return len(self._heap)


class MedianFinder:
    def __init__(self):
        self.lower_half = Heap(heapq.heappush_max, heapq.heappop_max)
        self.upper_half = Heap(heapq.heappush, heapq.heappop)

    def addNum(self, num: int) -> None:
        self.lower_half.push(num)
        self.upper_half.push(self.lower_half.pop())

        if len(self.upper_half) > len(self.lower_half):
            self.lower_half.push(self.upper_half.pop())

    def findMedian(self) -> float:
        if not self.lower_half:
            return float("nan")

        if len(self.lower_half) > len(self.upper_half):
            return float(self.lower_half.top())

        return (self.lower_half.top() + self.upper_half.top()) / 2
