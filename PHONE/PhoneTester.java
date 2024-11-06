package PHONE;

public class PhoneTester {
    public static void main(String[] args) {
        Phone samsung = new Phone();

        System.out.println("Details for samsung - Defaults");
        System.out.println(samsung.getPhoneNumber());
        System.out.println(samsung.getOwnersName());
        System.out.println(samsung.getPrice());

        Phone iPhone = new Phone("0899899099", "Anandhan", 2000);
        System.out.println(iPhone.getOwnersName());
        System.out.println(iPhone.getPhoneNumber());
        System.out.println(iPhone.getPrice());

        iPhone.setOwnersName("Jeshmitha");
        iPhone.setPhoneNumber("457689");
        iPhone.setPrice(400);

        System.out.println("Updated details for iPhone");
        System.out.println(iPhone.getOwnersName());
        System.out.println(iPhone.getPhoneNumber());
        System.out.println(iPhone.getPrice());
    }
}
