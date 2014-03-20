/**
 * Write a program that takes three integer command-line arguments
 * and prints equal if all three are equal
 * and not equal otherwise.
 */
import java.util.Scanner;
import java.io.BufferedInputStream;

public class Test {
    private static String CHARSET = "UTF-8";
    public static void main(String [] args)
    {
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new BufferedInputStream(System.in),CHARSET);
            while(scanner.hasNext())
            {
                try
                {
                    int i1 = scanner.nextInt();
                    int i2 = scanner.nextInt();
                    int i3 = scanner.nextInt();
                    if (i1 == i2 && i2 == i3)
                    {
                        System.out.println("equal");
                    }
                    else
                    {
                        System.out.println("not equal");
                    }
                }
                catch(Exception e)
                {
                    throw new java.util.InputMismatchException("Wrong parameter.");
                }
            }
        }
        finally
        {
            scanner.close();
        }
        
    }
}