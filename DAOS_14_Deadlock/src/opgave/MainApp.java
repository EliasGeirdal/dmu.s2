package opgave;

public class MainApp {
	public static void main(String[] args) {
		Stack stack = new Stack();
		PushThread push = new PushThread(stack);
		PopThread pop = new PopThread(stack);
		push.start();
		pop.start();
	}
}
