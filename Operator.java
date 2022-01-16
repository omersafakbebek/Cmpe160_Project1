
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	public int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	public int otime;
	public int omessage;
	public double omb;
	
	Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID=ID;
		this.talkingCharge=talkingCharge;
		this.messageCost=messageCost;
		this.networkCharge=networkCharge;
		this.discountRate=discountRate;
	}
	public double calculateTalkingCost(int minute, Customer customer) {
		if (customer.getAge()<18 || customer.getAge()>65) {
			return talkingCharge*(100-customer.getOperator().discountRate)*minute/100;
		} else {
			return talkingCharge*minute;
		}
	}
	public double calculateMessageCost(int quantity, Customer customer, Customer other) {
		if (customer.getOperator().ID==other.getOperator().ID) {
			return messageCost*(100-customer.getOperator().discountRate)*quantity/100;
		}
		else {
			return messageCost*quantity;
		}
	}
	public double calculateNetworkCost(double amount) {
		return networkCharge*amount;
	}
	public double getTalkingCharge() {
		return talkingCharge;
	}
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	public double getMessageCost() {
		return messageCost;
	}
	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}
	public double getNetworkCharge() {
		return networkCharge;
	}
	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

