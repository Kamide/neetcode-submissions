"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""


class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        ordered = sorted(intervals, key=lambda x: x.start)
        return all(a.end <= b.start for a, b in zip(ordered, ordered[1:]))
