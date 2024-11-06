package FAMILY;

public class Family {
    public static void main(String[] args){
        System.out.println("Details for Jhon");
        Person people = new Person(22,"John","Dublin");
        System.out.println("Name: "+people.getName());
        System.out.println("Age: "+people.getAge());
        System.out.println("Address: "+people.getAddress());


        System.out.println("Details for Ann");
        Person people2 = new Person(25,"Ann","Galway");
        System.out.println("Name: "+people2.getName());
        System.out.println("Age: "+people2.getAge());
        System.out.println("Address: "+people2.getAddress());


        System.out.println("Number of People: "+Person.getCount() );

        System.out.println("Updated details for John");
        people.setName("Jack");
        people.setAge(23);
        people.setAddress("Cork");
        System.out.println("Name: "+people.getName());
        System.out.println("Age: "+people.getAge());
        System.out.println("Address: "+people.getAddress());

    }
}
