
public class SortSelection {

    public Comparable [] sort(Comparable [] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i; j < a.length; j++)
            {
                if (this.more(a[i], a[j]))
                {
                    this.swap(a, i, j);
                }
            }
        }
        return a;
    }

    private boolean more(Comparable v, Comparable w)
    {
        return v.compareTo(w) > 0;
    }

    private void swap(Comparable [] a, int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String [] args)
    {
        SortSelection ss = new SortSelection();
        Integer [] arr = {11, 10, 12, 9, 6, 8, 9, 10, 3, 4, 5, 1, 2, 7, 5, 2, 1, 6};
        Comparable [] newArr = ss.sort(arr);
        for (int i = 0; i < newArr.length; i++)
        {
            System.out.print(newArr[i] + " ");
        }
    }
}
