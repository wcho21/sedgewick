package edu.princeton.cs.algs4;

public class FixedCapacityStackOfStrings {
  private String[] arr;
  private int n;

  public FixedCapacityStackOfStrings(int cap) {
    this.arr = new String[cap];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void push(String item) {
    arr[n++] = item;
  }

  public String pop() {
    return arr[--n];
  }

  // test
  public static void main(String[] args) {
    FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);

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
