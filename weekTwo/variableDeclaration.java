package weekTwo;

import java.util.Scanner;

public class variableDeclaration {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("My name is Soniya Anandhan:");
        int age = 28;
        double phone = 1234;
        float interest = 5.5f;
        double distance = 30000;
        String message = "Age: " + age + "\n" +"Phone: "+phone+ "\n" +"Interest: "+interest+ "\n" +"Distance: "+distance+"\n";
        System.out.println(message);


    }
}
