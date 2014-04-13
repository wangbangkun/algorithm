
public class SortMerge<Item extends Comparable<Item>>
{
    private Item [] tmp;

    public void sort(Item [] a)
    {
        this.tmp = (Item [])(new Comparable[a.length]);
        this.sort(a, 0, a.length - 1);
    }

    private void sort(Item [] a, int lo, int hi)
    {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi -lo)/2;
        this.sort(a, lo, mid);
        this.sort(a, mid + 1, hi);
        this.merge(a, lo, mid, hi);
    }

    private void merge(Item [] a, int lo, int mid, int hi)
    {
        int i = lo, j = mid + 1;
        for (int k= lo; k <= hi; k++) {
            this.tmp[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = a[j++];
            }
            else if (j > hi) {
                a[k] = this.tmp[i++];
            }
            else if (this.less(this.tmp[j], this.tmp[i])) {
                a[k] = this.tmp[j++];
            }
            else {
                a[k] = this.tmp[i++];
            }
        }
    }

    private boolean less(Item v, Item w)
    {
        return v.compareTo(w) < 0;
    }

    public static void main(String [] args) {
        String [] a = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        SortMerge m = new SortMerge();
        m.sort(a);
        for (String c : a) {
            System.out.print(c + " ");
        }
    }
}
