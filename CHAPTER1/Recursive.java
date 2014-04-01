/*
 * Write a recursive static method that computes the value of ln(N!).
 */
public class Recursive
{
    private static double logarithm(int N)
    {
        double d = (double)(Recursive.factorial(N));
        return Math.log(d);
    }

    private static int factorial(int N)
    {
        if (N < 0)
        {
            throw new IllegalArgumentException();
        }
        if (N == 0 || N == 1)
        {
            return 1;
        }
        else
        {
            return N * factorial(N - 1);
        }
    }

    public static void main(String [] args)
    {
        System.out.println(Recursive.logarithm(-5));
        System.out.println(Recursive.logarithm(5));
    }
}
