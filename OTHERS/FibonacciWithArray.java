
public class FibonacciWithArray
{
    private long [] fib;
    private int N;

    public FibonacciWithArray(int N)
    {
        this.fib = new long[N];
        this.N = N;
    }

    public long [] fib()
    {
        if (this.N <= 2)
        {
            for (int i = 0; i < this.N; i++)
            {
                this.fib[i] = i;
            }
        }
        else
        {
            this.fib[0] = 0;
            this.fib[1] = 1;
            for (int i = 2; i < this.N; i++)
            {
                this.fib[i] = this.fib[i - 2] + this.fib[i - 1];
            }
        }
        return this.fib;
    }

    public static void main(String [] args)
    {
        int count = Integer.parseInt(args[0]);
        FibonacciWithArray fwa = new FibonacciWithArray(count);
        long [] result = fwa.fib();
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}