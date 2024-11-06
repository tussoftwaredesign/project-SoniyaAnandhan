package BUS;

public class BusDepot {

    public static void main(String[] args){
        Driver driverOne = new Driver();
        driverOne.setName("John");
        driverOne.setPhoneNumber(110);

        Bus busOne = new Bus();
        busOne.setMake("Volvo");
        busOne.setNumberOfSeats(45);

        System.out.println("Bus [Make="+busOne.getMake()+" number of seats="+ busOne.getNumberOfSeats()+" Driver "+driverOne.getName()+"]" );

        Bus busTwo = new Bus();
        busTwo.setMake("Mercedes");
        busTwo.setNumberOfSeats(50);

        System.out.println("Bus [Make="+busTwo.getMake()+" number of seats="+ busTwo.getNumberOfSeats()+" no driver assigned]" );

        Driver driverTwo = new Driver("Tom",999);

        Bus busThree = new Bus();
        busThree.setMake("Ford");
        busThree.setNumberOfSeats(20);
        System.out.println("Bus [Make="+busThree.getMake()+" number of seats="+ busThree.getNumberOfSeats()+" Driver "+driverTwo.getName()+"]" );

        System.out.println(Bus.getBusCount());
    }
}
