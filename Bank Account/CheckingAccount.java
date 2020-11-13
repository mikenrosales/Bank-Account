public class CheckingAccount extends BankAccount{
	//given variables
	private double minimum;
	private double charge;

	//default constructor
	public CheckingAccount(){}

	public CheckingAccount(String acctNum, String acctName, double balance, double minimum, double charge){
		super(acctNum, acctName, balance);
		this.minimum = minimum;
		this.charge = charge;
	}

	//setters
	public void setMinimum(double minimum){
		this.minimum = minimum;
	}

	public void setCharge(double charge){
		this.charge = charge;
	}

	//getters
	public double getMinimum(){ 
		return minimum; 
	}
	public double getCharge(){ 
		return charge; 
	}

	//method cash check
	public void cashCheck(String payee, double amount){
        if (super.withdraw(amount) == true){
            if (super.getBalance() < this.getMinimum())
                super.setBalance(super.getBalance() - this.charge); 
        }
    }

	//string override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()+", " + minimum + ", " + charge);
		return sb.toString();
	}

	public static void main(String[] args) {
		// CheckingAccount ca = new CheckingAccount("Acct-001","Maria Paz",5000, 2000, 500);
		// System.out.println(ca);
		// ca.cashCheck("CIT",3500);
		// System.out.println(ca);

		// CheckingAccount ca = new CheckingAccount("Acct-001","Maria Paz",5000, 2000, 500);
		// System.out.println(ca);
		// ca.cashCheck("CIT",7000);
		// System.out.println(ca);

		// CheckingAccount ca = new CheckingAccount("Acct-001","Maria Paz",5000, 2000, 500);
		// System.out.println(ca);
		// ca.cashCheck("CIT",5000);
		// System.out.println(ca);
	}

}