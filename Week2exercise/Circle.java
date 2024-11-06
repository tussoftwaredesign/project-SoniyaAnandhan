package Week2exercise;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        final double PI = 3.14;
        System.out.print("Enter a radius ---> ");
        double radius = sc.nextInt();

        System.out.println("The area of the Circle is: "+ PI * Math.pow(radius,2));
        System.out.println("The diameter of the Circle is: "+ 2*radius);
        System.out.println("The circumference of the Circle is: "+ 2*PI*radius);
    }
}
