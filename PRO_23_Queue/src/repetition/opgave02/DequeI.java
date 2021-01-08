package repetition.opgave02;

public interface DequeI<T> {

	public void addFirst(T element);

	public void addLast(T element);

	public T removeFirst();

	public T removeLast();

	public T getFirst();

	public T getLast();

	public int size();

	public boolean isEmpty();

}
