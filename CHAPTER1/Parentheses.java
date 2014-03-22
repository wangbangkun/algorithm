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
        
    }
}
