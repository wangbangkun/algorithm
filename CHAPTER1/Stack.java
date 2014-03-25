/*
 * Add a method peek() to Stack that returns the most recently inserted item on the stack(without poping it).
 */
public class Stack<Item>
{
    private Node first;
    private int N;

    public boolean isEmpty()
    {
        return this.N == 0;
    }

    public int size()
    {
        return this.N;
    }

    public void push(Item item)
    {
        Node oldfirst = this.first;
        this.first = new Node();
        this.first.item = item;
        this.first.next = oldfirst;
        this.N++;
    }

    public Item pop()
    {
        if (this.N == 0)
        {
            throw new java.util.NoSuchElementException();
        }
        Item item = this.first.item;
        this.first = this.first.next;
        this.N--;
        return item;
    }

    public Item peek()
    {
        return this.first.item;
    }

    private class Node
    {
        Item item;
        Node next;
    }
}