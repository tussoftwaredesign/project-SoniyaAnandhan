package Week2exercise;

import java.util.Scanner;

public class MathsOps {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value of num1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter a value of num2: ");
        int num2 = sc.nextInt();

        System.out.println("The sum of the value is: "+(num1+num2));
        System.out.println("The product of the value is: "+(num1*num2));
        System.out.println("The difference of the value is: "+(num1-num2));
        if(num2==0){
            System.out.println("Cannot divide by zero!!!");
        }else {
            System.out.println("The quotient of the value is: "+ (num1/num2));
        }

    }
}
