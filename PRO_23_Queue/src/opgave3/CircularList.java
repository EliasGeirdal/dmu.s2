package opgave3;

import java.util.Random;

import queueopgaver.CircularArrayQueue;

public class CircularList extends CircularArrayQueue {

	public CircularList() {
	}

	public Person[] kanibalisering(int spring) {
		int size = super.size();
		Person[] temp = new Person[size];
		Person[] personer = new Person[size];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = (Person) super.dequeue();
		}
		Random r = new Random();
		int j = r.nextInt(size);
		for (int i = 0; i < temp.length; i++) {
			personer[i] = temp[j];
			j = (j + spring) % size;
		}
		return personer;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
