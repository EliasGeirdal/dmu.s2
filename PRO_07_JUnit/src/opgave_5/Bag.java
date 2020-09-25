package opgave_5;

import java.util.Collection;

public interface Bag<E> extends Collection<E> {

	/** Add a String to the bag */
	public void add(String s);

	/** Get the count of Strings equal to s in the bag */
	public int getCount(String s);

}
