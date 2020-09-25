package opgave_01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyTime implements Serializable {
	private int time;

	public MyTime() {
		time = 0;
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

}
