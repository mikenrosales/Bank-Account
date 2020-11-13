public class TestClass{
    //input method
    public void input(){
        SavingsAccount objectA = new SavingsAccount("Act-001", "Mary Joy Torcende", 10000, 0.25);
        SavingsAccount objectB = new SavingsAccount("Act-002", "Matt Plaza", 5000, 0.20);
        CheckingAccount objectC = new CheckingAccount("Act-003", "David Andrew", 20000, 10000, 200);
        objectA.withdraw(1000);
        objectB.deposit(5500);
        objectC.cashCheck("Sheryl Cruz",5000);
        objectA.fundTransfer(objectB,2000);
        System.out.println(objectA);
        System.out.println(objectB);
        System.out.println(objectC);
    }

    public static void main(String[] args){
        TestClass test = new TestClass();
        test.input();
    }

}

class BankAccount{
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

}

class SavingsAccount extends BankAccount{
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
    
}

class CheckingAccount extends BankAccount{
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

}