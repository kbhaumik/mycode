import java.util.*;

public class BSTLeftSum {
  int sum = 0;

  public int leftSum(Node root, Node parent) {
    if (root == null) return sum;
    leftSum(root.left, root);
    if (root.left == null && parent.left == root && root.right == null) {
      sum = sum + root.data;
    }
    leftSum(root.right, root);
    return sum;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(5);
    root.right = new Node(15);
    root.left.left = new Node(10);
    root.left.right = new Node(12);
    root.left.right.left = new Node(6);
    root.right.right = new Node(8);
    root.right.right.left = new Node(5);
    BSTLeftSum obj = new BSTLeftSum();
    obj.leftSum(root, root);
    System.out.println("Sum of left leaves: " + obj.sum);
  }

  static class Node {
    Node left;
    Node right;
    int data;

    public Node(int i) {
      data = i;
      right = null;
      left = null;
    }
  }
}
