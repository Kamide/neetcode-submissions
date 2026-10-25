Interval = tuple[int, int]
Start = 0
End = 1


class Solution:
    def insert(self, intervals: list[Interval], new_interval: Interval) -> list[Interval]:
        merged: list[Interval] = []

        (start, end) = new_interval

        for interval in intervals:
            if interval[End] < start:
                merged.append(interval)

            elif interval[Start] > end:
                merged.append((start, end))
                (start, end) = interval

            else:
                start = min(start, interval[Start])
                end = max(end, interval[End])

        merged.append((start, end))

        return merged
