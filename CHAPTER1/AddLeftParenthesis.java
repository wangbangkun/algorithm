/*
 * Write a program that takes from standard input an 
 * expression without left parentheses and prints the
 * equivalent infix expression with the parentheses inserted.
 * For example,given the input :
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
import java.util.Scanner;
import java.io.BufferedInputStream;

public class AddLeftParenthesis
{
    private static String CHARSET = "UTF-8";
    

    public Stack<String> getStack()
    {
        return new Stack<String>();
    }

    private class Stack<String>
    {
        private Node last;
        private int N;

        public Stack()
        {
            this.last = null;
            this.N = 0;
        }

        public void push(String str)
        {
            Node oldlast = this.last;
            this.last = new Node();
            this.last.str = str;
            this.last.next = oldlast;
            this.N++;
        }

        public String pop()
        {
            if (this.N == 0)
            {
                throw new java.util.NoSuchElementException();
            }
            String s = this.last.str;
            this.last = this.last.next;
            this.N--;
            return s;
        }

        private class Node
        {
            String str;
            Node next;
        }
    }

    public static void main(String [] args)
    {
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new BufferedInputStream(System.in), CHARSET);
            AddLeftParenthesis alp = new AddLeftParenthesis();
            Stack<String> optStack = alp.getStack();
            Stack<String> numStack = alp.getStack();
            while (scanner.hasNext())
            {
                String s = scanner.next();
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                {
                    optStack.push(s);
                }
                else if (s.equals(")"))
                {
                    String opt = optStack.pop();
                    String rightOptNum = numStack.pop();
                    String leftOptNum = numStack.pop();
                    String tmpResult = "( " + leftOptNum + " " + opt + " " + rightOptNum + " )";
                    numStack.push(tmpResult);
                }
                else
                {
                    numStack.push(s);
                }
            }
            System.out.println(numStack.pop());
        }
        finally
        {
            scanner.close();
        }
    }
}
