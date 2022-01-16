
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	public int ID;
	public String name;
	private int age;
	private Operator operator;
	private Bill bill;
	public int ctime;
	public int cmessage;
	public double cmb;
		
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID=ID;
		this.name=name;
		this.age=age;
		this.operator=operator;
		bill=new Bill(limitingAmount);
		
		
	}
	public void talk(int minute, Customer other) {
		if (this != other && getBill().check(getBill().getCurrentDebt()+getOperator().calculateTalkingCost(minute, this))) {
			ctime+=minute;
			other.ctime+=minute;
			operator.otime+=minute;
			other.operator.otime+=minute;
			getBill().add(getOperator().calculateTalkingCost(minute, this));
		}
	}
	public void message(int quantity, Customer other) {
		if (this != other && getBill().check(getBill().getCurrentDebt()+getOperator().calculateMessageCost(quantity, this,other))) {
			cmessage+=quantity;
			operator.omessage+=quantity;
			getBill().add(getOperator().calculateMessageCost(quantity, this,other));
		}
	}
	public void connection(double amount) {
		if (getBill().check(getBill().getCurrentDebt()+getOperator().calculateNetworkCost(amount))) {
		cmb+=amount;
		operator.omb+=amount;
		getBill().add(getOperator().calculateNetworkCost(amount));
		}
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

