package edu.princeton.cs.algs4;

public class FixedCapacityStack<Item> {
  private Item[] arr;
  private int n;

  public FixedCapacityStack(int cap) {
    @SuppressWarnings("unchecked")
    Item[] items = (Item[])new Object[cap];
    this.arr = items;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    arr[n++] = item;
  }

  public Item pop() {
    return arr[--n];
  }

  // test
  public static void main(String[] args) {
    FixedCapacityStack<String> s = new FixedCapacityStack<>(100);

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
