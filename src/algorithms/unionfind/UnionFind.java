package algorithms.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * TODO: Complete implementation based on the references
 */
// References
// edu.princeton.cs.algs4.QuickUnionUF
// edu.princeton.cs.algs4.QuickFindUF
// edu.princeton.cs.algs4.WeightedQuickUnionUF


public class UnionFind {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);

        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }

//        StdOut.println(uf.count() + " components");
    }
}

class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
    }
}


class QuickUnionUF {
    private int[] id, sz; // sz for weight of the tree

    public QuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i) {
        while ( i != id[i] ) {

            // Path compression logic
            id[i] = id[id[i]];

            i = id[i];
        }

        return i;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        // Weight logics
        //・ Link root of smaller tree to root of larger tree.
        //・ Update the sz[] array.
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else { id[j] = i; sz[i] += sz[j]; }
    }
}