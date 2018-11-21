import java.util.HashMap;

public class FindLongStrInDictionary {

  private HashMap<String, String> dic = new HashMap<String, String>();
  private int max = -1;
  private String maxStr = "";

  public void populateDictionary(String[] strs) {
    for (String str : strs) {
      dic.put(str, str);
    }
  }

  public void combinations(String suffix, String prefix) {
    if (prefix.length() < 0) {
      System.out.println(suffix);
      return;
    }
    System.out.println(suffix);
    if (dic.containsKey(suffix)) {
      if (suffix.length() > max) {
        max = suffix.length();
        maxStr = suffix;
      }
    }
    for (int i = 0; i < prefix.length(); i++)
      combinations(suffix + prefix.charAt(i), prefix.substring(i + 1, prefix.length()));
  }

  public static void main(String[] args) {

    FindLongStrInDictionary obj = new FindLongStrInDictionary();
    String[] strs = {"able", "ale", "apple", "bale", "kangaroo"};
    String input = "abppplee";
    obj.populateDictionary(strs);
    obj.combinations("", input);
    System.out.println("max String " + obj.maxStr + " count " + obj.max);
  }
}
