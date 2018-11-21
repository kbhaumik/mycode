import java.util.*;

public class WordBreak {
  Set<String> dict = new HashSet<String>();

  public WordBreak() {
    dict.add("this");
    dict.add("is");
    dict.add("kaushik1");
  }

  public boolean find(String words, Set dict, StringBuilder answer) {
    if (words.length() == 0) {
      System.out.println(" the answer " + answer.toString());
      return true;
    } else {
      String word = "";
      int i = 0;
      while (i < words.length()) {
        word = word + words.charAt(i);
        if (dict.contains(word)) {
          if (find(words.substring(i + 1), dict, answer.append(word).append(" "))) return true;
          else {
            i++;
          }
        } else {
          i++;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    WordBreak wb = new WordBreak();
    StringBuilder sb = new StringBuilder("");

    if (wb.find("thisiskaushik", wb.dict, sb)) {
      System.out.println("match");
      System.out.println(" the answer " + sb.toString());
    } else {
      System.out.println(" no match");
      System.out.println(" the answer " + sb.toString());
    }
  }
}
