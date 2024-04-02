package edu.princeton.cs.algs4;

public class QuickUnionUF {
  private int[] id; // integer key assumed
  private int[] sz;
  private int count;

  public QuickUnionUF(int n) {
    this.count = n;
    this.id = new int[n];
    this.sz = new int[n];
    for (int i = 0; i < n; ++i) {
      this.id[i] = i;
      this.sz[i] = 1;
    }
  }

  public int count() {
    return this.count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    while (p != this.id[p]) {
      p = this.id[p];
    }

    return p;
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) {
      return;
    }

    int pSize = sz[pRoot];
    int qSize = sz[qRoot];
    if (pSize < qSize) {
      id[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    } else {
      id[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    }

    this.count--;
  }

  public static void main(String[] args) {
    int n = StdIn.readInt();
    QuickUnionUF uf = new QuickUnionUF(n);
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
