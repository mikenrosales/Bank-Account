public class BankAccount{
    //given variables
    private String AccountName;
    private String AccountNumber;
    private double balance;

    private double amount;

    //default constructor
    public BankAccount(){}

    //constructor
    public BankAccount(String acctNum, String acctName, double balance){
        this.AccountNumber = acctNum;
        this.setAccountName(acctName);
        this.balance = balance;
    }

    //setters
    public void setAccountName(String AccountName){
        if (AccountName.split(" ").length > 1){
            this.AccountName = AccountName;
        }
        else{
            this.AccountName = "John Doe";
        }
    }
    public void setAccountNumber(String AccountNumber){
        this.AccountNumber = AccountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    //getters
    public String getAccountName(){
        return AccountName;
    }
    public String getAccountNumber(){
        return AccountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public double getAmount(){
        return amount;
    }

    //deposit method
    public double deposit(double amount){
        if (amount > 0){
            return this.balance = this.balance + amount;
        }
        else{
            return this.balance;
        }
    }

    //withdraw method
    public boolean withdraw(double amount){
        if(amount <= balance){
            balance = balance - amount;
            return true;
        }
        else{
            return false;
        }
    }

    //transfer method
    public void fundTransfer(BankAccount obj, double amount){
        boolean withdraw = this.withdraw(amount);
        if(withdraw){
            obj.deposit(amount);
        }
    }

    //string override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(AccountNumber+", "+AccountName+", "+balance);
        return sb.toString();
    }

	//tester
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
