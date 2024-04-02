package edu.princeton.cs.algs4;

public class QuickFindUF {
  private int[] id; // integer key assumed
  private int count;

  public QuickFindUF(int n) {
    this.count = n;
    this.id = new int[n];
    for (int i = 0; i < n; ++i) {
      this.id[i] = i;
    }
  }

  public int count() {
    return this.count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);

    if (pId == qId) {
      return;
    }

    for (int i = 0; i < this.id.length; ++i) {
      if (this.id[i] == pId) {
        this.id[i] = qId;
      }
    }
    this.count--;
  }

  public static void main(String[] args) {
    int n = StdIn.readInt();
    QuickFindUF uf = new QuickFindUF(n);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.connected(p, q)) {
        continue;
      }
      uf.union(p, q);
      StdOut.println(p + " " + q);
    }
    StdOut.println(uf.count() + " components");
  }
}
