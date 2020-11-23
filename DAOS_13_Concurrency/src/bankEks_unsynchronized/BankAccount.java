package bankEks_unsynchronized;

import java.util.concurrent.Semaphore;

public class BankAccount {

	private double balance;
	private Semaphore sem = new Semaphore(1);

	public void setBalance(double amount, String action) throws InterruptedException {
		sem.acquire();
		if (action.equals("c")) {
			balance = balance + amount;
		}
		if (action.equals("d")) {
			balance = balance - amount;
		}
		sem.release();
	}

	public double getBalance() {
		return balance;
	}
}
