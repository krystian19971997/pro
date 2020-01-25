package others.worker;

import others.model.Account;

public class AccountHolder implements Runnable {
	private Account account;

	//private Account s

	public AccountHolder(Account account) {
		this.account = account;

	}

	@Override
	public void run() {
		// ile razy wyplacic
		for (int i = 1; i <= account.getRate(); i++) {
			makeWithdrawal(account.getAmountToWithdraw());
			if (account.getBalance() < 0) {
				System.out.println("Brak środków na koncie!");
			}
		}
	}

	private synchronized void makeWithdrawal(int withdrawAmount) {
		if (account.getBalance() >= withdrawAmount) {
			System.out.println(Thread.currentThread().getName()	+ " wypłaca: $"+withdrawAmount);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
			account.withdraw(withdrawAmount);
			System.out.println(Thread.currentThread().getId()+". "+Thread.currentThread().getName()	+ " pomyślnie wypłacił "+withdrawAmount+ " zł"
			+ ", pozostało mu: "+account.getBalance() +" zł na koncie");
		} else {
			System.out.println(Thread.currentThread().getName()+" Masz mniej niż chcesz wypłacić [ "+ withdrawAmount+" ] zł,  pozostało "
			+ account.getBalance()+" zł na Twoim koncie");
		}
	}
}