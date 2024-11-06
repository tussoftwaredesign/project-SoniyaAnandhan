package Week2exercise;

import java.util.Scanner;

public class IfLogicalOps {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value of num1 --> ");
        int num1 = sc.nextInt();
        System.out.print("Enter a value of num2 --> ");
        int num2 = sc.nextInt();

        if (num1<0 && num2<0){
            System.out.println("Both numbers are negative ");
        }else if (num1 >0 && num2 >0){
            System.out.println("Both are positive numbers ");
        } else if (num1==0 || num2 ==0) {
            System.out.println("One of the number is zero 0");
        } else if(num1<0 || num2<0) {
            System.out.println("Atleast one number is negative");
        }
    }
}
