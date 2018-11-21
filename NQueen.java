import java.util.*;

public class NQueen {

  private int n;
  private int[][] sol;

  public NQueen(int n) {
    this.n = n;
    sol = new int[n][n];
  }

  public static void main(String[] args) {
    NQueen nq = new NQueen(8);

    if (nq.searchPlace(0)) {
      System.out.println(" found a solution");
      nq.print();
    } else {
      nq.print();
      System.out.println(" No Solution found");
    }
  }

  public void print() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(" " + sol[i][j]);
      }
      System.out.println();
    }
  }

  public boolean searchPlace(int q) {
    if (q == n) return true;
    for (int i = 0; i < n; i++) {
      if (canPlace(q, i)) {
        sol[q][i] = 1;
        if (searchPlace(q + 1)) return true;
        sol[q][i] = 0;
      }
    }
    return false;
  }

  private boolean canPlace(int q, int i) {
    for (int k = i; k < i; k++) {
      if (sol[q][k] == 1) return false;
    }

    for (int k = i, j = q; k >= 0 && j >= 0; k--, j--) {
      if (sol[j][k] == 1) {
        return false;
      }
    }

    // check lower diagonal
    for (int k = i, j = q; k < sol.length && j >= 0; k++, j--) {
      if (sol[j][k] == 1) {
        return false;
      }
    }

    return true;
  }
}
