/*
 *Add a method isFull() to FixedCpacityStackOfStrings.
 */
public class FixedCpacityStackOfStrings
{
    private String [] a;
    private int N;

    public FixedCpacityStackOfStrings(int cap)
    {
        this.a = new String[cap];
    }

    public boolean isEmpty()
    {
        return this.N == 0;
    }

    public boolean isFull()
    {
        return this.a.length == this.N;
    }

    public int size()
    {
        return this.N;
    }

    public void push(String item)
    {
        this.a[this.N++] = item;
    }

    public String pop()
    {
        return this.a[--this.N];
    }
}
