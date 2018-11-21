import java.util.*;

public class ExternalSort {
  private ArrayList<ArrayList<Integer>> lists;

  public ExternalSort(ArrayList<ArrayList<Integer>> lists) {

    this.lists = lists;
  }

  public List<Integer> sort() {
    PriorityQueue pq = new PriorityQueue<Pair>();
    int count = 0;
    int listCount = 0;
    ArrayList<Integer> l = new ArrayList<Integer>();

    for (List<Integer> list : lists) {

      Pair p = new Pair(count, listCount, list.get(count));
      pq.add(p);
      listCount++;
    }
    while (!pq.isEmpty()) {
      Pair pair = (Pair) pq.poll();
      int listIndex = pair.list;
      Integer d = pair.data;
      count = pair.index;
      count = count + 1;
      if (lists.get(listIndex).size() >= count) {
        l.add(d);

        pair = new Pair(count, listIndex, lists.get(listIndex).get(count));
        pq.add(pair);
        count = 0;
      }
    }
    return l;
  }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<Integer>();
    Collections.addAll(a, 1, 2, 3, 4);
    ArrayList<Integer> b = new ArrayList<Integer>();
    Collections.addAll(b, 20, 22, 23, 27);
    ArrayList<Integer> c = new ArrayList<Integer>();
    Collections.addAll(c, 30, 31, 33, 41);
    ArrayList<Integer> d = new ArrayList<Integer>();
    Collections.addAll(d, 40, 44, 45, 46);

    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    lists.add(0, a);
    lists.add(1, b);
    lists.add(2, c);
    lists.add(3, d);

    ExternalSort sorts = new ExternalSort(lists);
    System.out.println(" sorted list " + sorts.sort());
  }

  static class Pair implements Comparable<Pair> {
    int index;
    int list;
    int data;

    public Pair(int i, int l, int d) {
      index = i;
      list = l;
      data = d;
    }

    @Override
    public int compareTo(Pair o) {
      return this.data >= o.data ? 1 : -1;
    }
  }
}
