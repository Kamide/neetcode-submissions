/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        var sorted = intervals
            .stream()
            .sorted(Comparator.comparingInt(x -> x.start))
            .toList();

        return IntStream
            .range(0, sorted.size() - 1)
            .allMatch(i -> sorted.get(i).end <= sorted.get(i + 1).start);
    }
}
