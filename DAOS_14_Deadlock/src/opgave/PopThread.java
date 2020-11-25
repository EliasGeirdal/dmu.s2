package opgave;

public class PopThread extends Thread {
	private Stack stack;

	public PopThread(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(100);
				stack.pop();
				System.out.println("Popped");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
