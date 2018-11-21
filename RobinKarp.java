import java.util.*;

public class RobinKarp {
  public static boolean searchPattern(String pattern, String str) {
    int patternLength = pattern.length();
    int patternHash = pattern.hashCode();

    for (int i = 0; i < str.length() - patternLength + 1; i = i + patternLength) {
      if (patternHash == str.substring(i, i + patternLength).hashCode()) {
        if (pattern.equals(str.substring(i, i + patternLength))) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("the pattenr match " + searchPattern("crab", "this is string"));
  }
}
