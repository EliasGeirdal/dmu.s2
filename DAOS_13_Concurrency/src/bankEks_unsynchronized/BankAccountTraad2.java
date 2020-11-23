package bankEks_unsynchronized;

public class BankAccountTraad2 extends Thread {

	private BankAccount ba;

	public BankAccountTraad2(BankAccount ba) {
		this.ba = ba;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 4) {
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				ba.setBalance(100, "d");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		System.out.println("Balancen er: " + ba.getBalance());
	}

}
