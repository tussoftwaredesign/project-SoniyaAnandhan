package Week2exercise;

import java.util.Scanner;

public class Modulus {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a x value: ");
        int x = sc.nextInt();
        System.out.print("Enter a y value: ");
        int y = sc.nextInt();

        if (y!=0){
            if(x%y ==0){
                System.out.println(x+" is multiple of " + y);
            }else{
                System.out.println(x + " is not multiple of " + y);
            }
        }else{
            System.out.println("Caught Error!!!!");
        }
//      Using the modulus operator (%), determine if x is a multiple of y.
    }
}
