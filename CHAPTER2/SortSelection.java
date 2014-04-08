
public class SortSelection<Item extends Comparable<Item>>
{

    public Item [] sort(Item [] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
            {
                if (this.more(a[min], a[j]))
                {
                    min = j;
                }
            }
            if (min != i)
            {
                this.swap(a, i, min);
            }
        }
        return a;
    }

    private boolean more(Item v, Item w)
    {
        return v.compareTo(w) > 0;
    }

    private void swap(Item [] a, int i, int j)
    {
        Item tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String [] args)
    {
        SortSelection<Integer> ssi = new SortSelection<Integer>();
        Integer [] iArr = {11, 10, 12, 9, 6, 8, 9, 10, 3, 4, 5, 1, 2, 7, 5, 2, 1, 6};
        Integer [] newIngArr = ssi.sort(iArr);
        for (int i = 0; i < newIngArr.length; i++)
        {
            System.out.print(newIngArr[i] + " ");
        }
        System.out.println();
        SortSelection<String> sss = new SortSelection<String>();
        String [] sArr = {"Z", "B", "A", "a", "C", "c", "X", "d", "W", "v", "Y"};
        String [] newStrArr = sss.sort(sArr);
        for (String s : newStrArr)
        {
            System.out.print(s + " ");
        }
    }
}
