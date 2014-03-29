
public class WeightedQuickUnionUF
{
    private int [] ids;
    private int [] weight;
    private int count;

    public WeightedQuickUnionUF(int N)
    {
        this.ids = new int[N];
        this.weight = new int[N];
        for (int i = 0; i < N; i++)
        {
            this.ids[i] = i;
            this.weight[i] = 1;
        }
        this.count = N;

    }

    public int count()
    {
        return this.count;
    }

    public boolean connected(int p, int q)
    {
        return this.find(p) == this.find(q);
    }

    public int find(int p)
    {
        while (p != this.ids[p])
        {
            p = this.ids[p];
        }
        return p;
    }

    public void union(int p, int q)
    {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP == rootQ)
        {
            return;
        }
        if (this.weight[rootP] < this.weight[rootQ])
        {
            this.ids[rootP] = rootQ;
            this.weight[rootQ] += this.weight[rootP];
        }
        else
        {
            this.ids[rootQ] = rootP;
            this.weight[rootP] += this.weight[rootQ];
        }
        this.count--;
    }
}