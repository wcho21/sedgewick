package edu.princeton.cs.algs4;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
  private Node first;
  private int n;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return this.first == null;
  }

  public int size() {
    return this.n;
  }

  public void push(Item item) {
    Node oldFirst = this.first;

    this.first = new Node();
    this.first.item = item;
    this.first.next = oldFirst;

    n++;
  }

  public Item pop() {
    Item item = this.first.item;
    this.first = this.first.next;
    n--;

    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = Stack.this.first;

    public boolean hasNext() {
      return this.current != null;
    }

    public Item next() {
      Item item = this.current.item;

      this.current = this.current.next;

      return item;
    }

    public void remove() {
      // do nothing
    }
  }

  // test
  public static void main(String[] args) {
    Stack<String> s = new Stack<>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();

      if (!item.equals("-")) {
        s.push(item);
      } else if (!s.isEmpty()) {
        StdOut.print(s.pop() + " ");
      }
    }

    StdOut.println("(" + s.size() + " left on stack)");
  }
}
