
public class FibonacciWithRecursion
{
    public static long fib(int N)
    {
        if (N == 0 || N == 1)
        {
            return N;
        }
        else 
        {
            return fib(N - 2) + fib(N - 1); 
        }
    }

    public static void main(String [] args)
    {
        int count = Integer.parseInt(args[0]);
        for (int i = 0; i < count; i++)
        {
            System.out.print(FibonacciWithRecursion.fib(i) + " ");
        }
    }
}