import java.util.*;

public class ReachToTarget {

  public void goToTarget(List<Integer> numList, int target, List<Integer> remainder) {
    int sum = 0;
    sum = getSum(remainder);
    if (sum == target) {
      System.out.println(" the numbers are " + remainder.toString());
    }
    if (sum > target) {
      return;
    }
    for (int i = 0; i < numList.size(); i++) {
      List<Integer> partial = new ArrayList<Integer>(remainder);
      for (int j = i; j < numList.size() - 1; j++) remainder.add(numList.get(j));

      partial.add(numList.get(i));
      goToTarget(remainder, target - sum, partial);
    }
  }

  private int getSum(List<Integer> numList) {

    int total = 0;
    for (int num : numList) {
      total = total + num;
    }
    return total;
  }

  public static void main(String[] array) {
    ReachToTarget obj = new ReachToTarget();
    Integer[] numbers = {3, 9, 8, 4, 5, 7, 10};
    List<Integer> numList = Arrays.asList(numbers);
    obj.goToTarget(numList, 15, new ArrayList<Integer>());
  }
}
