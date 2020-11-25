package opgave;

public class PushThread extends Thread {
	private Stack stack;

	public PushThread(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(200);
				stack.push(1);
				System.out.println("pushed");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
