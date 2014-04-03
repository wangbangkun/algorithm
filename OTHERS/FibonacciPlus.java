/*
 * Use both recursion and cache to solve Fibonacci.
 * COPIED FROM http://blog.informatech.cr/category/development/java/
 */

import java.util.Map;
import java.util.HashMap;

public class FibonacciPlus {

    private static Map<Integer,Long> cache = new HashMap<>();

    static {
        cache.put(0, 0L);
        cache.put(1, 1L);
    }
    
    public static long fibonacci(int x)
    {
        return cache.computeIfAbsent(x, n->fibonacci(n - 1) + fibonacci(n - 2));
    }

    public static void main(String [] args)
    {
        int count = Integer.parseInt(args[0]);
        for (int i = 0; i < count; i++)
        {
            System.out.print(FibonacciPlus.fibonacci(i) + " ");
        }
    }
}
