public class SavingsAccount extends BankAccount{
	private double interestRate;

	//default constructor
	public SavingsAccount(){}

	public SavingsAccount(String acctNum, String acctName, double balance, double interest){
		super(acctNum, acctName, balance);
		this.interestRate = interest;
	}

	//setter
	public void setInterestRate(double interestRate){
		this.interestRate = interestRate;
	}

	//getter
	public double getInterestRate(){
		return interestRate;
	}

    //method to calculate interest
	public void calculateInterest(){
		super.setBalance(super.getBalance() + (super.getBalance() * interestRate));
	}

    //string override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString() + ", " + interestRate);
        return sb.toString();
    }

    //tester goes here
    public static void main(String[] args) {
		// SavingsAccount sa = new SavingsAccount("Acct-001", "Maria Paz", 5000.0, 0.2);
		// System.out.println(sa);
		// sa.deposit(200);
		// sa.calculateInterest();
		// System.out.println(sa);
		// SavingsAccount sa2 = new SavingsAccount("Acct-002", "JuneMarch", 5000.0, 0.25);
		// System.out.println(sa2);

		// BankAccount  account1 = new BankAccount ("Acct-001","Maria Paz", 5000);
		// BankAccount  account2 = new BankAccount ("Acct-002","Juan dela Cruz", 2000);
		// System.out.println(account1);
		// System.out.println(account2);
		// account1.deposit(200);
		// System.out.println(account1.withdraw(7000));
		// account1.fundTransfer(account2, 2000);
		// System.out.println(account1);
		// System.out.println(account2);
    }
    
}

