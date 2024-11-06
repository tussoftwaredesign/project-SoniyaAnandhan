package PHONE;

public class Phone {
    private String phoneNumber="1234567";
    private String ownersName="Soniya";
    private double price= 1200;

//    Constructor
    public Phone(){

    }
    public Phone(String phoneNumber,String ownersName,double price){
        this.phoneNumber=phoneNumber;
        this.ownersName =ownersName;
        this.price=price;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getOwnersName(){
        return ownersName;
    }
    public double getPrice(){
        return price;
    }
    public void setPhoneNumber(String aNumber){
        this.phoneNumber = aNumber;
    }
    public void setOwnersName(String aOwnersName){
        this.ownersName = aOwnersName;
    }
    public void setPrice(double aPrice){
        this.price = aPrice;
    }
}
