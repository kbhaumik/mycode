import java.util.*;

public class MergeSortedArrays {

  public int[] mergeArrays(int[] a, int[] b) {

    int[] c = new int[a.length + b.length];
    int p = 0;
    int q = 0;
    int count = 0;
    while (p <= a.length - 1 && q <= b.length - 1) {
      if (a[p] < b[q]) {
        c[count] = a[p];
        p++;
        count++;

      } else if (a[p] > b[q]) {
        c[count] = b[q];
        q++;
        count++;
      }
    }
    while (p <= a.length - 1) {
      c[count] = a[p];
      p++;
      count++;
    }
    while (q <= b.length - 1) {
      c[count] = b[q];
      q++;
      count++;
    }

    return c;
  }

  public static void main(String[] args) {
    MergeSortedArrays obj = new MergeSortedArrays();
    int[] a = new int[] {1, 3, 7, 9};
    int[] b = new int[] {8, 14, 78};
    int[] result = obj.mergeArrays(a, b);
    System.out.println(Arrays.toString(result));
  }
}
