package epi;

public class Pair<T, E>
{
	public T first;
	public E second;

	public Pair(T t, E e)
	{
		this.first = t;
		this.second = e;
	}

	public String toString()
	{
		return first.toString() + "    " + second.toString();
	}
}
