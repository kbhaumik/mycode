import java.util.*;

public class MyLinkedList {
  private Node head;

  public MyLinkedList(Node head) {
    this.head = head;
  }

  public void addToLast(int data) {
    Node current = head;
    Node newNode = new Node(data);
    if (head == null) head = newNode;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
    newNode.previous = current;
    current = current.next;
  }

  public void addToFront(int data) {
    Node current = head;
    Node newNode = new Node(data);
    if (head == null) head = newNode;
    else {
      newNode.next = current;
      current.previous = newNode;

      head = newNode;
    }
  }

  public void removeFromFront() {
    Node current = head;
    if (head == null) return;
    head = current.next;
    current.previous = null;
  }

  public void removeFromBack() {
    Node current = head;
    if (head == null) return;

    while (current.next != null) {
      current = current.next;
    }
    current.previous.next = null;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (head != null) sb.append(head.data + " =>");
    Node current = head.next;
    while (current != null) {
      sb.append(current.data + " =>");
      current = current.next;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Node headNode = new Node(4);
    MyLinkedList ll = new MyLinkedList(headNode);
    ll.addToLast(6);
    ll.addToLast(4);
    System.out.println(" linked list" + ll.toString());
  }

  static class Node {
    Node next;
    Node previous;
    int data;

    public Node(int data) {
      this.data = data;
      next = null;
      previous = null;
    }
  }
}
