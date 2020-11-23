package bankEks_semafor;

public class TestBankAccount {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
			BankAccountTraad bat1 = new BankAccountTraad(ba);
			BankAccountTraad2 bat2 = new BankAccountTraad2(ba);
			
			bat1.start();
			bat2.start();
			
			try {
				bat1.join();
				bat2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Slut balancen er: " + ba.getBalance());
		}
}
