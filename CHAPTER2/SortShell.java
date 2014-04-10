
public class SortShell<Item extends Comparable<Item>>
{

    public Item [] sort(Item [] a)
    {
        int len = a.length;
        int h = 1;
        while (h < len/3) {
            h = 3 * h + 1;
        }
        while (h >= 1 ) {
            for (int i = h; i < len; i++) {
                Item current = a[i];
                for (int j = i; j >= h && this.more(a[j - h], a[j]); j -= h) {
                    a[j] = a[j - h];
                    a[j - h] = current;
                }
            }
            h /= 3;
        }
        return a;
    }

    private boolean more(Item v, Item w)
    {
        return v.compareTo(w) > 0;
    }

    public static void main(String [] args)
    {
        SortShell<String> ss = new SortShell<String>();
        String [] sArr = {"S", "H", "E", "L", "L", "S", "O", "R", "T", "E","X", "A", "M", "P", "L", "E"};
        for (String s : ss.sort(sArr)) {
            System.out.print(s + " ");
        }
    }
}
