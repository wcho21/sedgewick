package edu.princeton.cs.algs4;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
  @SuppressWarnings("unchecked")
  private Item[] arr = (Item[]) new Object[1];
  private int n = 0;

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  private void resize(int max) {
    // copy
    @SuppressWarnings("unchecked")
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < n; ++i) {
      temp[i] = this.arr[i];
    }

    this.arr = temp;
  }

  public void push(Item item) {
    if (n == this.arr.length) {
      resize(2 * this.arr.length);
    }

    this.arr[n++] = item;
  }

  public Item pop() {
    Item item = this.arr[--n];

    if (n > 0 && n == this.arr.length / 4) {
      resize(this.arr.length / 2);
    }

    return item;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = ResizingArrayStack.this.n;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return ResizingArrayStack.this.arr[--i];
    }
    public void remove() {
      // do nothing
    }
  }

  // test
  public static void main(String[] args) {
    ResizingArrayStack<String> s = new ResizingArrayStack<>();

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
