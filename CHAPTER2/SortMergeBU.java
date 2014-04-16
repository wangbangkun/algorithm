
public class SortMergeBU<Item extends Comparable<Item>>
{
    private Item [] tmp;

    public void sort(Item [] a)
    {
        int N = a.length;
        for (int sz = 1; sz < N; sz += sz ) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                this.merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public void merge(Item [] a, int lo, int mid, int hi)
    {
        int i = lo, j = mid + 1;
        this.tmp = (Item []) new Comparable[a.length];
        for (int k = lo; k <= hi; k++) {
            this.tmp[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = this.tmp[j];
                j++;
            } else if (j > hi) {
                a[k] = this.tmp[i];
                i++;
            } else if (this.less(this.tmp[j], this.tmp[i])) {
                a[k] = this.tmp[j];
                j++;
            } else {
                a[k] = this.tmp[i];
                i++;
            }
        }
    }

    public boolean less(Item v, Item w)
    {
        return v.compareTo(w) < 0;
    }

    public static void main(String [] args) {
        String [] a = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        SortMergeBU<String> s = new SortMergeBU<String>();
        s.sort(a);
        for (String c : a) {
            System.out.print(c + " ");
        }
    }
}
