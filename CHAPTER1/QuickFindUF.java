/*
 * Develop classes QuickFindUF that implement quick-find.
 */
public class QuickFindUF
{
    private int [] id;
    private int count;

    public QuickFindUF(int N)
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
        if (this.connected(p, q))
        {
            return;
        }
        for (int i = 0; i < this.id.length; i++)
        {
            if (this.id[i] == this.find(p))
            {
                this.id[i] = this.find(q);
            }
        }
        this.count--;
    }

    public int find(int p)
    {
        return this.id[p];
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
