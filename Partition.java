import java.util.*;

public class Partition {

  public int getPartition(int[] a) {
    int low = 0;
    int high = a.length - 1;
    int pivot = low;
    System.out.println("pivot" + pivot);
    while (low < high) {
      while (a[low] < a[pivot]) low++;
      while (a[high] > a[pivot]) high--;
      int tmp = a[high];
      a[high] = a[low];
      a[low] = tmp;
    }

    return low;
  }

  public static void main(String[] args) {
    Partition obj = new Partition();
    int[] a = new int[] {1, 10, 7, 9, 5, 11, 45, 8, 43};

    obj.quickSort(0, a.length - 1, a);
    System.out.println(Arrays.toString(a));
  }

  public void quickSort(int low, int high, int[] a) {
    if (low > high) return;
    int partition = getPartition(a);

    quickSort(low, partition, a);
    quickSort(partition + 1, high, a);
  }
}
