import java.util.*;

public class IntervalTest {
  private static class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    private void setStart(int start) {
      this.start = start;
    }

    private void setEnd(int end) {
      this.end = end;
    }
  }

  public static void main(String[] args) {
    List<Interval> l = new ArrayList<>();
    Interval first = new Interval(1, 3);
    Interval second = new Interval(2, 4);
    Interval third = new Interval(7, 8);
    l.add(first);
    l.add(second);
    l.add(third);
    IntervalTest intv = new IntervalTest();
    System.out.println(" the results " + intv.collapseIntervals(l));
  }

  public List<Interval> collapseIntervals(List<Interval> l) {

    List<Interval> results = new ArrayList<Interval>();
    // Collections.sort(l);
    /*
        { start: 0, end: 5 },
        { start: 1, end: 7 },
        { start: 8, end: 12 },
        { start: 10, end: 15 }

        result: {
            { start: 0, end: 7 },
            { start: 8, end: 15 }
        }
    */
    results.add(l.remove(0));
    for (Interval interval : l) {
      isInRange(results, interval);
    }
    return results;
  }

  void isInRange(List<Interval> results, Interval interval) {
    for (Interval result : results) {
      if ((interval.start > result.start && interval.end > result.end)
          || (interval.start < result.start && interval.end < result.end)) {
        result.setEnd(interval.end);
        break;
      } else {
        results.add(interval);
      }
    }
  }
}
