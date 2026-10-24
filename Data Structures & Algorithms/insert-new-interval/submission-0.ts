type Interval = [start: number, end: number];
const start = 0;
const end = 1;

class Solution {
    insert(intervals: Interval[], newInterval: Interval): Interval[] {
        return [...intervals, newInterval]
            .sort((a, b) => a[start] - b[start])
            .reduce((intervals, interval) => {
                const last = intervals.at(-1);

                if (last == null || interval[start] > last[end]) {
                    intervals.push(interval);
                } else {
                    last[end] = Math.max(last[end], interval[end]);
                }

                return intervals;
            }, [] as Interval[]);
    }
}
