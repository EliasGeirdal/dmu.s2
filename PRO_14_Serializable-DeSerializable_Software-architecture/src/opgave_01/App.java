package opgave_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class App {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		MyTime time = new MyTime();
		time.increase();
		time.increase();
		time.increase();
		System.out.println(time.getTime());
		time.serialize();

		// punkt 5
		MyTime deSerializeTime = null;
		try {
			FileInputStream fis = new FileInputStream("Time.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			deSerializeTime = (MyTime) ois.readObject();
			ois.close();
			fis.close();
		} finally {
			System.out.println("Deserialized object...");
			System.out.println(deSerializeTime.getTime());
		}
	}
}
