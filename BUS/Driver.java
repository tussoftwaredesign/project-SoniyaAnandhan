package BUS;

public class Driver {
    private String name;
    private Integer phoneNumber;

    public Driver(){

    }
    public Driver(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
