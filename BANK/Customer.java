package BANK;

public class Customer {
    private int accountNo;
    private double balance;
    private String name;
    private static int count = 0;

    public Customer(){
        count++;


    }
    public Customer(String name,int accountNo,double balance){
        this.name=name;
        this.accountNo = accountNo;
        this.balance = balance;
        count++;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
