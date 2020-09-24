package opgave_02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MyTime implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int time;
	private List<String> times;

	public MyTime() {
		time = 0;
		times = new LinkedList<>();
	}

	/**
	 * Save current time into times.
	 */
	public void saveTime() {
		times.add("" + time);
	}

	/**
	 * Serialize this object.
	 */
	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("Time.txt");
			ObjectOutputStream ois = new ObjectOutputStream(fos);
			ois.writeObject(this);
			ois.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void increase() {
		time++;
	}

	public void reset() {
		time = 0;
	}

	public int getTime() {
		return time;
	}

}
