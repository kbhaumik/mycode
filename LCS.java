import java.util.*;

public class LCS {
  public void doLCS(String str1, String str2) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;
    int len = 0;
    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();
    len = calcLCS(charArray1, charArray2, i, j, sb);
    System.out.println(" the lcs " + sb.toString() + " the length " + len);
  }

  private int calcLCS(char[] charArray1, char[] charArray2, int i, int j, StringBuilder sb) {

    if (i == charArray1.length - 1 || j == charArray2.length - 1) return 0;
    else if (charArray1[i] == charArray2[j] && (i < charArray1.length && j < charArray2.length)) {
      sb.append(charArray1[i]);
      return 1 + calcLCS(charArray1, charArray2, i + 1, j + 1, sb);
    } else {
      return Math.max(
          calcLCS(charArray1, charArray2, i, j + 1, sb),
          calcLCS(charArray1, charArray2, i + 1, j, sb));
    }
  }

  public static void main(String[] array) {
    LCS obj = new LCS();
    obj.doLCS("ABACCD", "ACDF");
  }
}
