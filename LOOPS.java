import java.util.InputMismatchException;
import java.util.Scanner;

public class LOOPS {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        whileLoop1();
//        whileLoop2();
//        whileLoop3();
//        doWhileLoop1();
//        doWhileLoop2();
//        doWhileLoop3();
//        forLoop1();
//        forLoop2();
//        forLoop3();
        histogram();

    }

    //    a. write a while loop that loops from 1 to 5 (use i and n variables respectively). Total the value
//of the loop control variable – use an appropriately named variable for the total.
    public static void whileLoop1() {
        int i = 1, n = 5, total = 0;
        while (i <= n) {
            total += i;
            System.out.println("loop1:i= " + i + ", The total is= " + total);
            i++;

        }
        System.out.println("The total is: " + total);
//        code a second while loop whose loop condition is exactly the same as the previous loop; the
//difference this time is that instead of incrementing by 1, the user specifies the increment
//value that you will use. Cater for exceptions in the input (in the second loop).
        i = 1;
        total = 0;
        System.out.print("Enter the increment value: ");

        try {
            int incMent = sc.nextInt();
            while (i <= n) {
                System.out.println("The loop2 i== " + i);
                total += i;
                i += incMent;

            }
            System.out.println("Total is: " + total);


        } catch (Exception e) {
            System.out.println("Throw exception invalid error: " + e);
        }
    }

    public static void whileLoop2() {
        int i = 5, n = 1, total = 0;
        while (i >= n) {
            total += i;
            System.out.println("loop1:i== " + i);
            i--;

        }
        System.out.println("The total is: " + total);
//        code a second while loop whose loop condition is exactly the same as the previous loop; the
//difference this time is that instead of incrementing by 1, the user specifies the increment
//value that you will use. Cater for exceptions in the input (in the second loop).
        i = 5;
        total = 0;
        System.out.print("Enter the increment value: ");

        try {
            int decMent = sc.nextInt();
            while (i >= n) {
                System.out.println("The loop2 i== " + i);
                total += i;
                i -= decMent;

            }
            System.out.println("Total is: " + total);


        } catch (Exception e) {
            System.out.println("Throw exception invalid error: " + e);

        }

    }

    //     whileloop3()
//a. Write a while loop that totals user-inputted numbers. The loop terminates when the user
//enters a negative number. The loop should not execute if the first number is negative. Cater
//for the InputMismatchException exception only.
//b. Write a second while loop that totals user-inputted numbers. This second version loops
//indefinitely until a negative number is entered. Cater for InputMismatchException’s.
    public static void whileLoop3() {
        int sum = 0, number = 0;


        try {
            System.out.println("Enter a number(-1 to exit): ");
            number = sc.nextInt();

            while (number >= 0) {
                sum += number;
                System.out.println("Enter a number to exit -1:");
                number = sc.nextInt();
            }
            System.out.println("The sum is: " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Caught exception!!!!");
        }

        sum = 0;
        try {
            while (true) {
                System.out.println("Enter a number(-1 to exit): ");
                number = sc.nextInt();

                if (number < 0) {
                    break;
                } else {
                    sum += number;

                }
                System.out.println("The sum is: " + sum);
            }
        } catch (InputMismatchException e) {
            System.out.println("Caught exception!!!!");
        }
    }

    public static void doWhileLoop1() {
        int i = 1, n = 5, total = 0;
        do {
            total += i;
            System.out.println("DowhileLoop1: i==" + i);
            i++;
        } while (i <= n);
        System.out.println("doWhileLoop1 total=: " + total);

        i = 1;
        total = 0;
        System.out.println("Enter a increment number: ");

        try {
            int incNumber = sc.nextInt();
            do {

                total += i;
                System.out.println("DoWhileLoop1: i==" + i);
                i += incNumber;

            } while (i <= n);
            System.out.println("The total is: " + total);
        } catch (InputMismatchException e) {
            System.out.println("Caught Error!!!");
        }
    }

    public static void doWhileLoop2() {
        int i = 5, n = 1, total = 0;
        do {
            total += i;
            System.out.println("DowhileLoop1: i==" + i);
            i--;
        } while (i >= n);
        System.out.println("doWhileLoop1 total=: " + total);

        i = 5;
        total = 0;
        System.out.print("Enter a increment number: ");

        try {
            int decNumber = sc.nextInt();
            do {

                total += i;
                System.out.println("DoWhileLoop1: i==" + i);
                i -= decNumber;

            } while (i >= n);
            System.out.println("The total is: " + total);
        } catch (InputMismatchException e) {
            System.out.println("Caught Error!!!");
        }
    }

    public static void doWhileLoop3() {
        int sum = 0, number = 0;
        try {
            System.out.print("Enter a number: ----> ");
            number = sc.nextInt();
            do {
                sum += number;
                System.out.print("Enter a number(-1 to exit) ----> ");
                number = sc.nextInt();

            } while (number >= 0);
            System.out.println("The sum is: " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Caught Error!!!!");
        }
        sum = 0;
        try {
            System.out.print("Enter a number----> ");

            do {
                number = sc.nextInt();
                if (number < 0) {
                    break;
                } else {
                    sum += number;
                    System.out.print("Enter a number (-1 to exit)----> ");
                    number += 1;

                }
            } while (number >= 0);
            System.out.println("The sum is: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Caught Errors!!!!");
        }
    }


//     forLoop1()
//a. Write a for loop that ranges between 1..20 in steps of 1; total the loop control variable.
//b. Code a second for loop that totals the loop control variable ranging from 5 to 20 (inclusive) in
//steps of 5. Output the totals.
//Sample run:
//Total is 210
//Total is 50

    public static void forLoop1() {
        int total = 0;
        for(int i=0; i<=20;i++){
            total+=i;
        }
        System.out.println("The total is: "+total);

        total = 0;
        for(int i=0; i<=20; i+=5){
            total+=i;
        }
        System.out.println("The total is: "+total);

    }

    public static void forLoop2() {
        int total = 0;
        for(int i=40;i>=30; i--){
            total += i;
        }
        System.out.println("The sum is " + total);


        total = 0;
        for(int i=40;i>=30;i-=5){
            total += i;
        }
        System.out.println("The sum is: "+ total);

    }
//     Write an infinite for loop. The loop asks the user to input a number. Total the user inputted
//numbers and exit the loop when –1 is entered. Cater for the InputMismatchException in the
//input.

    public static void forLoop3(){
        int total = 0, number = 0;

        try{
            for(;;){
                System.out.print("Enter the number(-1 to exit)---> ");
                number = sc.nextInt();
                if(number==-1){
                    break;
                }else{
                    total+=number;
                }

            }

        }catch(InputMismatchException e){
            System.out.println("Caught Error!!!!");
        }
        System.out.println("The total is: "+total);
    }

    public static void histogram(){
        try{
             System.out.print("Enter the rows--> ");
             int x = sc.nextInt();
             System.out.print("Enter the columns--> ");
             int y = sc.nextInt();

            System.out.println("Using for loops:");
            for (int i=1; i<=x;i++) {
                for (int j = 1; j <= y; j++) {
                    System.out.print("*");
                }
                 System.out.println();
            }


            int i = 1, j=1;
            System.out.println("Using while loop:");
            while(i<=x){
                j=1;
                while(j<=y){
                    System.out.print("*");
                    j++;
                }
                System.out.println();
                i++;
            }
        }catch (InputMismatchException e){
            System.out.println("Caught Errors!!!!!");
        }
    }
}