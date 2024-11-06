package BANK;

public class Bank {

    public static void main(String[] args){

      Customer customerOne = new Customer();
      customerOne.setName("James");
      customerOne.setBalance(1000.00);
      customerOne.setAccountNo(1234);
      System.out.println("Customer" + "[accountNo="+ customerOne.getAccountNo()+", name="+ customerOne.getName()+", balance="+ customerOne.getBalance()+"]");
      System.out.println();

      Customer customerTwo = new Customer("Soniya",2345,1999.0);
      System.out.println("Customer" + "[accountNo="+ customerTwo.getAccountNo()+", name="+ customerTwo.getName()+", balance="+ customerTwo.getBalance()+"]");


      customerTwo.setName("Katy");
      customerTwo.setBalance(2500.00);
      customerTwo.setAccountNo(384);
      System.out.println("Customer" + "[accountNo="+ customerTwo.getAccountNo()+", name="+ customerTwo.getName()+", balance="+ customerTwo.getBalance()+"]");
      System.out.println("Number of Customers:"+Customer.getCount());
    }
}
