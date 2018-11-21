import java.util.*;

public class MovingAvg {
  public static double[] getMovingAvg(int[] a, int windowSize) {
    double[] avg = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      if (i < windowSize && i != 0) {

        avg[i] = (avg[i - 1] + a[i]);

        avg[i] = avg[i] / (i + 1);
      } else if (i == 0) {
        avg[i] = a[i];
      } else {
        for (int j = i - windowSize; j <= i; j++) {
          avg[i] = avg[i - 1] + a[i];
        }
        avg[i] = avg[i] / windowSize;
      }
    }
    return avg;
  }

  public static void main(final String[] array) {
    int[] a = {1, 2, 3, 4};
    System.out.println(Arrays.toString(getMovingAvg(a, 2)));
  }
}
