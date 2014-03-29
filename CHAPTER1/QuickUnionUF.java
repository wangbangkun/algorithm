/*
 * Develop classes QuickUnionUF that implements quick-union
 */
public class QuickUnionUF
{
    private int [] id;
    private int count;

    public QuickUnionUF(int N)
    {
        this.id = new int[N];
        for (int i = 0; i < N; i++)
        {
            this.id[i] = i;
        }
        this.count = N;
    }

    public void union(int p, int q)
    {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP == rootQ)
        {
            return;
        }
        this.id[rootQ] = this.id[rootP];
        this.count--;
    }

    public int find(int p)
    {
        while (p != this.id[p])
        {
            p = this.id[p];
        }
        return p;
    }

    public boolean connected(int p, int q)
    {
        return this.id[p] == this.id[q];
    }

    public int count()
    {
        return this.count;
    }
}
