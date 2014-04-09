
public class SortInsertion<Item extends Comparable<Item>> 
{
    public Item [] sort(Item [] a)
    {
        for (int i = 1; i < a.length; i++) {
            Item current = a[i];
            for (int j = i; j > 0 && this.more(a[j - 1], current); j--) {
                a[j] = a[j - 1];
                a[j - 1] = current;
            }
        }
        return a;
    }

    private boolean more(Item v, Item w)
    {
        return v.compareTo(w) > 0;
    }

    public static void main(String [] args)
    {
        SortInsertion<Integer> sii = new SortInsertion<Integer>();
        Integer [] iArr = {6, 8, 9, 3};
        for (int i : sii.sort(iArr)) {
            System.out.print(i + " ");
        }
        System.out.println();
        SortInsertion<String> sis = new SortInsertion<String>();
        String [] sArr = {"S", "O", "R", "T", "E","X", "A", "M", "P", "L", "E"};
        for (String s : sis.sort(sArr)) {
            System.out.print(s + " ");
        }
    }
}
