
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		PrintStream outstream1;
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
		int ID=0; int oID=0;
		for (int i=0;i<N;i++) {
			int act=reader.nextInt();
			if (act==1) {
				String name=reader.next(); int age=reader.nextInt(); int operatorId=reader.nextInt(); double lim=reader.nextDouble();
				if (operatorId<oID && ID<C) {
					customers[ID] = new Customer(ID,name,age,operators[operatorId],lim);
					ID+=1;
				}
			}
			if (act==2) {
				double talkingCharge=reader.nextDouble(); double messageCost=reader.nextDouble(); double networkCharge=reader.nextDouble(); int discountRate=reader.nextInt();
				if (oID<O) {
					operators[oID]=new Operator(oID,talkingCharge,messageCost,networkCharge,discountRate);
					oID+=1;
				}
			}
			if (act==3) {
				int firstCustomer=reader.nextInt();	int secondCustomer=reader.nextInt();int talkTime=reader.nextInt();
				if (firstCustomer<ID && secondCustomer<ID) {
					customers[firstCustomer].talk(talkTime, customers[secondCustomer]);	
				}
			}	
			if (act==4) {
				int firstCustomer=reader.nextInt();	int secondCustomer=reader.nextInt();int messageQuantity=reader.nextInt();
				if (firstCustomer<ID && secondCustomer<ID) {
					customers[firstCustomer].message(messageQuantity, customers[secondCustomer]);
				}
			}
			if (act==5) {
				int firstCustomer=reader.nextInt();	double iamount=reader.nextDouble();
				if (firstCustomer<ID) {
					customers[firstCustomer].connection(iamount);
				}
			}
			if (act==6) {
				int firstCustomer=reader.nextInt();	double pAmount=reader.nextDouble();
				if (firstCustomer<ID) {
					customers[firstCustomer].getBill().pay(pAmount);
				}
			}	
			if (act==7) {
				int firstCustomer = reader.nextInt(); int newOperator=reader.nextInt();
				if (firstCustomer<ID && newOperator<oID) {
					customers[firstCustomer].setOperator(operators[newOperator]);
				}
			}
			if (act==8) {
				int firstCustomer=reader.nextInt();	double newLimit=reader.nextDouble();
				if (firstCustomer<ID) {
					customers[firstCustomer].getBill().changeTheLimit(newLimit);
				}
			}
		}
		for (int i=0;i<O;i++) {
			outstream1.print("Operator "+i+" : "+ operators[i].otime+" "+ operators[i].omessage +" " );
			outstream1.printf("%.2f",operators[i].omb);
			outstream1.println();
		}
		if (C>0) {
			String tCustomer=""; int t=-1; String mCustomer=""; int m=-1; String iCustomer=""; double ic=-1;
			for (int i=0;i<C;i++) {
				outstream1.print("Customer "+i+" : ");
				outstream1.printf("%.2f",customers[i].getBill().paidMoney);
				outstream1.print(" ");
				outstream1.printf("%.2f", customers[i].getBill().getCurrentDebt());
				outstream1.println();
				if (customers[i].ctime>t) {
					t=customers[i].ctime;
					tCustomer=customers[i].name;
				}
				if (customers[i].cmessage>m) {
					m=customers[i].cmessage;
					mCustomer=customers[i].name;
				}
				if (customers[i].cmb>ic) {
					ic=customers[i].cmb;
					iCustomer=customers[i].name;
				}
			}
			outstream1.println(tCustomer+" : "+t);
			outstream1.println(mCustomer+" : "+ m);
			outstream1.print(iCustomer+" : ");
			outstream1.printf("%.2f",ic);	
		}
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

			