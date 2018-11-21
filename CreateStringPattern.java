import java.util.*;

public class CreateStringPattern {

  public void getPermutation(String prefix, String str, List<String> permutations) {
    int n = str.length();

    if (n == 0) {
      permutations.add(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        if (!prefix.equals("")) permutations.add(prefix);
        getPermutation(
            prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutations);
      }
    }
  }

  boolean isValid(String str) {
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) < str.charAt(i + 1)) return false;
    }
    return true;
  }

  public String createString(int n, int k, StringBuilder sb, List<String> list) {
    if (n == 0 && k == 0) return sb.toString();
    else {
      for (String str : list) {
        if (isValid(str)) {
          sb.append(str);

          createString(n - 1, k, sb, list);
          createString(n, k - 1, sb, list);
        }
      }
    }
    return "";
  }

  public static void main(String[] args) {
    CreateStringPattern obj = new CreateStringPattern();
    List<String> holds = new ArrayList<String>();
    obj.getPermutation("", "ABC", holds);
    StringBuilder sb = new StringBuilder();
    System.out.println(" the permutations are " + holds);
    System.out.println(" CreateString " + obj.createString(2, 2, sb, holds));
  }
}
