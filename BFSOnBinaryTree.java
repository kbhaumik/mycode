import java.util.*;

public class BFSOnBinaryTree {
  private Node root = null;

  public BFSOnBinaryTree(Node tree) {
    root = tree;
  }

  public ArrayList<Integer> bfs() {
    Queue<Node> q = new LinkedList<Node>();
    ArrayList<Integer> l = new ArrayList<Integer>();
    q.add(root);
    while (!q.isEmpty()) {
      Node temp = q.poll();
      if (temp.left != null) q.add(temp.left);
      if (temp.right != null) q.add(temp.right);

      l.add(temp.data);
    }
    return l;
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
    BFSOnBinaryTree bfs = new BFSOnBinaryTree(root);

    System.out.println("BFS traversal" + bfs.bfs());
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
