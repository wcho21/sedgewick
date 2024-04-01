package edu.princeton.cs.algs4;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
  private Node first;

  private class Node {
    Item item;
    Node next;
  }

  public void add(Item item) {
    Node oldFirst = this.first;
    this.first = new Node();
    this.first.item = item;
    this.first.next = oldFirst;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = Bag.this.first;

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
    Bag<String> b = new Bag<>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();

      if (!item.equals("-")) {
        b.add(item);
      }
    }

    for (String s : b) {
      StdOut.println(s);
    }
  }
}
