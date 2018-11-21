import java.util.*;

public class MergeTwoSortedLinkedList {
  Node a;
  Node b;

  public MergeTwoSortedLinkedList(Node a, Node b) {
    this.a = a;
    this.b = b;
  }

  public void mergeTwo() {
    Node result;
    result = mergeList(a, b);
    while (result != null) {
      System.out.print(" " + result.data + " =>");
      result = result.next;
    }
  }

  private Node mergeList(Node a, Node b) {
    Node result;
    if (a == null && b != null) {
      return b;
    } else if (a != null && b == null) {
      return a;
    }
    if (a.data < b.data) {
      result = a;
      result.next = mergeList(a.next, b);
    } else if (a.data > b.data) {
      result = b;
      result.next = mergeList(a, b.next);

    } else {
      result = a;
      result.next = b.next;
    }
    return result;
  }

  public static void main(String[] args) {
    Node headNode = new Node(4);
    Node a = new Node(6);
    Node b = new Node(8);
    headNode.next = a;
    a.next = b;

    Node headNode1 = new Node(2);
    Node c = new Node(6);
    Node d = new Node(10);
    headNode1.next = c;
    c.next = d;
    MergeTwoSortedLinkedList obj = new MergeTwoSortedLinkedList(headNode, headNode1);
    obj.mergeTwo();
  }

  static class Node {
    Node next;
    int data;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }
}
