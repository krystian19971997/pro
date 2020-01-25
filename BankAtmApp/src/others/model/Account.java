package others.model;
import connection.QueryExecutor;

public class Account {

	private Integer id;
	public String userName;
	private Float balance;
	private int AmountToWithdraw;
	int rate;

	public int getRate() {
		return rate;
	}



	public void setAmountToWithdraw(int AmountToWithdraw, int rate) {
		this.AmountToWithdraw = AmountToWithdraw;
		this.rate=rate;
	}
	public int getAmountToWithdraw() {
		return AmountToWithdraw;
	}
	public Account(String userName, Integer userId, Float balance) {
		this.userName = userName;
		this.id=userId;
		this.balance=balance;
	}
	public Float getBalance() {
		return this.balance;
	}
	public void withdraw(int amount) {
		this.balance = this.balance - amount;
		QueryExecutor.executeQuery("UPDATE konto SET stanKonta = " + this.balance + " WHERE idKlient = " + id);
	}
}