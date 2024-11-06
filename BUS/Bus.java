package BUS;

public class Bus {
    private int numberOfSeats;
    private static int busCount;
    private Driver driver;
    private String make;

    public Bus(){
        busCount++;

    }
    public Bus(String make,int numberOfSeats,Driver driver){
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.driver = driver;
        busCount++;
    }
    public Driver getDriver(String name){
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    public static int getBusCount(){
        return busCount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
