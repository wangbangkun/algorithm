/*
 * Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced.
 * For example,your program should print true for [()]{} and false for [(]).
 */
import java.util.Scanner;
import java.io.BufferedInputStream;

public class Parentheses {

    private static String CHARSET = "UTF-8";
    private String [] a = new String[1];
    private int N = 0;

    public void push(String item)
    {
        if (this.N == this.a.length)
        {
            this.resize(2 * this.N);
        }
        this.a[this.N++] = item;
    }

    public String pop()
    {
        String item = this.a[this.N - 1];
        this.a[--this.N] = null;
        if (this.N > 0 && this.N == this.a.length/4)
        {
            this.resize(this.a.length/2);
        }
        return item;
    }

    public int getSize()
    {
        return this.N;
    }

    private void resize(int len)
    {
        String [] tmp = new String[len];
        for (int i = 0; i < N; i++)
        {
            tmp[i] = this.a[i];
        }
        this.a = tmp;
    }

    public static void main(String [] args)
    {
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new BufferedInputStream(System.in), CHARSET);
            String s = "";
            while (scanner.hasNext())
            {
                String x = scanner.next();
                if (! x.equals(";"))
                {
                    if (x.indexOf(";") > 0)
                    {
                        s = s + x.substring(0, x.indexOf(";"));
                        break;
                    }
                    else
                        s += x;
                }
                else 
                    break;
            }
            boolean b = false;
            String [] arr = s.split("");
            Parentheses stack = new Parentheses();
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].equals("{") || arr[i].equals("[") || arr[i].equals("("))
                {
                    stack.push(arr[i]);
                }
                else
                {
                    if (arr[i].equals("}") && stack.getSize() > 0)
                    {
                        String pop = stack.pop();
                        if (pop.equals("{"))
                        {
                            b = true;
                        }
                        else
                        {
                            b = false;
                            break;
                        }
                    }
                    else if (arr[i].equals("]") && stack.getSize() > 0)
                    {
                        String pop = stack.pop();
                        if (pop.equals("["))
                        {
                            b = true;
                        }
                        else
                        {
                            b = false;
                            break;
                        }
                    }
                    else if (arr[i].equals(")") && stack.getSize() > 0)
                    {
                        String pop = stack.pop();
                        if (pop.equals("("))
                        {
                            b = true;
                        }
                        else
                        {
                            b = false;
                            break;
                        }
                    }
                }
            }
            System.out.println(b);
        }
        finally
        {
            scanner.close();
        }
    }
}
