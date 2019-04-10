/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        ArrayList<Interval> intervals = new ArrayList<>();
        int start, end;

        for (List<Interval> avail : avails) {
            for (Interval interval : avail) {
                start = interval.start;
                end = interval.end;

                for (int i = 0; i < intervals.size(); i++) {
                    if (intersect(intervals.get(i), start, end)) {
                        start = Math.min(start, intervals.get(i).start);
                        end = Math.max(end, intervals.get(i).end);
                        intervals.remove(i);
                        i--;
                    }
                }
                intervals.add(new Interval(start, end));
            }
        }
        Interval[] arr = new Interval[intervals.size()];
        intervals.toArray(arr);
        Arrays.sort(arr, (Interval i1, Interval i2) -> {
            if (i1.start == i2.start) {
                return i1.end - i2.end;
            }
            return i1.start - i2.start;
        });

        List<Interval> ret = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            ret.add(new Interval(arr[i - 1].end, arr[i].start));
        }
        return ret;
    }

    public boolean intersect(Interval a, int start, int end) {
        return a.start >= start && a.start <= end
                || start >= a.start && start <= a.end;
    }
}
