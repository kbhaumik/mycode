import java.util.*;

public class StringSubtract {
  public void substract(String str1, String str2) {
    char[] chars = str2.toCharArray();
    String str = "";
    for (int i = 0; i < chars.length; i++) {
      str = str1.replace(chars[i], ';');
    }
    System.out.println(str.replaceAll(";", ""));
  }

  public static void main(String[] args) {
    StringSubtract obj = new StringSubtract();
    obj.substract("abc", "ac");
  }
}
