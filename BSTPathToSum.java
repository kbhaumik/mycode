import java.util.*;

public class BSTPathToSum {
  Node root = null;
  int sum;

  public void pathToSum(Node root, String path) {
    if (root != null) {

      if (root.data > sum) return;
      else {
        sum = sum - root.data;
        path = path + "=>" + root.data;
        if (sum == 0) {

          System.out.println("the path is " + path);
        }
        pathToSum(root.left, path);
        pathToSum(root.right, path);
      }
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(7);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    BSTPathToSum bst = new BSTPathToSum(root, 10);
    bst.pathToSum(root, "");
  }

  public BSTPathToSum(Node root, int sum) {
    this.root = root;
    this.sum = sum;
  }

  static class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
}
