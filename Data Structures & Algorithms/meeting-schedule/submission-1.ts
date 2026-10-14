class Solution {
    canAttendMeetings = (intervals: { start: number; end: number }[]) =>
        [...intervals]
            .sort((a, b) => a.start - b.start)
            .every((a, b, c) => a.end <= (c[b + 1]?.start ?? Infinity));
}
