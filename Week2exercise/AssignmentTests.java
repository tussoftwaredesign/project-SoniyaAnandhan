package Week2exercise;

import java.util.Scanner;

public class AssignmentTests {
    public static void main(String[] args){

//        1.	Write a program called AssignmentTests.
//                Declare and initialize an integer x to 0.
//        Take in the x value from the user. Evaluate x,
//        if x is between 1 and 5 inclusive output the square of x;
//        if x is between 6 and 10 inclusive output the cube of x;
//        if x is less than or equal to 0 or greater than 10 then flag an error.

        Scanner sc = new Scanner(System.in);

        int x = 0;
        System.out.print("Enter a x value (1....10)-->  ");
        x = sc.nextInt();

        if(x>=1 && x<=5){
            System.out.println("The output of the square x is: " + Math.pow(x,2));
        } else if (x>=6 && x<=10) {
            System.out.println("The output of the cube is: "+ Math.pow(x,3));

        }else {
            System.out.println("Error cought!!!!!");
        }

    }
}
