package edu.princeton.cs.algs4;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
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

  public void enqueue(Item item) {
    Node oldLast = this.last;

    this.last = new Node();
    last.item = item;
    last.next = null;

    if (isEmpty()) {
      this.first = this.last;
    } else {
      oldLast.next = this.last;
    }

    n++;
  }

  public Item dequeue() {
    Item item = this.first.item;
    this.first = this.first.next;

    if (isEmpty()) {
      this.last = null;
    }
    n--;

    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = Queue.this.first;

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
    Queue<String> q = new Queue<>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();

      if (!item.equals("-")) {
        q.enqueue(item);
      } else if (!q.isEmpty()) {
        StdOut.print(q.dequeue() + " ");
      }
    }

    StdOut.println("(" + q.size() + " left on queue)");
  }
}
