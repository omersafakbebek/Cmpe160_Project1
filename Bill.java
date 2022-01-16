
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private double limitingAmount;
	private double currentDebt;
	public double paidMoney;
	
	Bill(double limitingAmount) {
		this.limitingAmount=limitingAmount;
		this.currentDebt=0;
	}
	boolean check(double amount) {
		if (amount>limitingAmount) {
			return false;
		}
		else {
			return true;
		}
	}
	public void add(double amount) {
		currentDebt+=amount;
	}
	public void pay(double amount) {
		if (currentDebt>amount) {
			currentDebt-=amount;
			paidMoney+=amount;
		}else {
			paidMoney+=getCurrentDebt();
			currentDebt-=getCurrentDebt();
		}
	}
	public void changeTheLimit(double amount) {
		if (currentDebt<=amount) {
			limitingAmount=amount;
		}
	}
	public double getLimitingAmount() {
		return limitingAmount;
	}
	public double getCurrentDebt() {
		return currentDebt;
	}

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

