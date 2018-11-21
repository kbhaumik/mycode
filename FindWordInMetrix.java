public class FindWordInMetrix {

  private int[][] sol;

  public static void main(String[] args) {
    FindWordInMetrix w = new FindWordInMetrix(5);
    char[][] matrix = {
      {'t', 'z', 'x', 'c', 'd'},
      {'a', 'h', 'n', 'z', 'x'},
      {'h', 'w', 'o', 'i', 'o'},
      {'o', 'r', 'n', 'r', 'n'},
      {'a', 'b', 'r', 'i', 'n'}
    };
    if (w.search("horizon", matrix)) {
      System.out.println("PATH FOUND");
    } else {
      System.out.println("NO PATH FOUND");
    }
  }

  public FindWordInMetrix(int n) {
    sol = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sol[i][j] = 0;
      }
    }
  }

  public boolean search(String word, char[][] mat) {
    int n = mat.length;
    boolean found = false;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        found = findWord(word, mat, sol, i, j, n, 0);
      }
    }
    return found;
  }

  public boolean findWord(String word, char[][] mat, int[][] sol, int i, int j, int n, int index) {
    if (sol[i][j] != 1 && word.charAt(index) != mat[i][j]) {
      return false;
    }
    if (index == word.length() - 1) {

      sol[i][j] = 1;
      return true;
    }
    sol[i][j] = 1;
    if (i + 1 < n && findWord(word, mat, sol, i + 1, j, n, index + 1)) {
      return true;
    }
    if (j + 1 < n && findWord(word, mat, sol, i, j + 1, n, index + 1)) {
      return true;
    }
    if (i - 1 >= 0 && findWord(word, mat, sol, i - 1, j, n, index + 1)) {
      return true;
    }
    if (j - 1 >= 0 && findWord(word, mat, sol, i, j - 1, n, index + 1)) {
      return true;
    }
    if (i + 1 < n && j + 1 < n && findWord(word, mat, sol, i + 1, j + 1, n, index + 1)) {
      return true;
    }
    if (i + 1 < n && j - 1 >= 0 && findWord(word, mat, sol, i + 1, j - 1, n, index + 1)) {
      return true;
    }
    if (i - 1 >= 0 && j + 1 < n && findWord(word, mat, sol, i - 1, j + 1, n, index + 1)) {
      return true;
    }
    if (i - 1 >= 0 && j - 1 >= 0 && findWord(word, mat, sol, i - 1, j - 1, n, index + 1)) {
      return true;
    }
    sol[i][j] = 0;

    return false;
  }
}
