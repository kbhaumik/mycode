import java.util.*;

public class FirstOccuarenceOfElements {
  public void getPosition(int b[]) {
    HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
    int count = 0;
    for (int i = 0; i < b.length; i++) {
      if (store.get(b[i]) == null) {
        store.put(new Integer(b[i]), count);
        count++;
      }
    }
    for (int j = 0; j < b.length; j++) {
      System.out.println(b[j] + "  " + store.get(new Integer(b[j])));
    }
  }

  public static void main(String[] args) {
    FirstOccuarenceOfElements obj = new FirstOccuarenceOfElements();

    int[] a = new int[] {1, 2, 3, 2, 5};

    obj.getPosition(a);
  }
}
