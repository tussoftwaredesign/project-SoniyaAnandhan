package Week2exercise;

import java.util.Scanner;

//1.	Write a program called AlgebraicExpression. This program is based on the
//expression y=ax3 + 7. Initialise x to 2 and a to 3.
// Using parentheses where needed ensure y evaluates to the following: 31 (the normal evaluation).
// Show also that by changing the position of the brackets a result of 108 and 66 can be achieved.
//2.	Look up the Math.pow function and use it to evaluate the above expression.



public class AlgebraicExpression {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);

        System.out.println("Evaluating y=ax^3+7 using different methods.... ");
        int x = 2, a=3;

        int y_Normal = a*x*x*x +7;
        System.out.println("Normal y_evaluation: " + y_Normal);

        int y_Method1 = a*x*x*(x+7);
        System.out.println("Method 1 y_evaluation: " + y_Method1);

        int y_method2 = (a*x)*x*(x+7);
        System.out.println("Method 2 y_evaluation: " + y_method2);

        int y_method3 = (a*x)*x*x+7;
        System.out.println("Method 3 y_evaluation: "+ y_method3);

        int y_method4 = a *(x*x*x)+7;
        System.out.println("Method 4 y_evaluation: "+ y_method4);

        int y_method5 = a*x*(x*x+7);
        System.out.println("Method 5 y_evaluation: "+ y_method5);

        double y_math = a* Math.pow(x,3)+7;
        System.out.println("Using math function y_evaluation: "+y_math);



    }
}
