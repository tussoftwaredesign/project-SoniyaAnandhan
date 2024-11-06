package weekOne;

import java.util.Scanner;

public class invoiceversionApp2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String choice = "yes";
        System.out.println("@@ Welcome to the invoice calculator @@");

        double totalNoOfInvoice = 0;


        while(choice.equalsIgnoreCase("Yes")) {


            System.out.print("Enter a Subtotal: ");
            double subTotal = sc.nextDouble();

//            3.	The discount is determined based on the value of subtotal
//            (>=500, discount is 0.25, >=200, discount is 0.2, >=100, discount is 0.1).
//            For values less than 100 no discount is applied.
            double discounts = discountValues(subTotal);
            System.out.println("Discount Percent is: " + discounts);
            double discountAmount = subTotal * discounts;
            System.out.println("Discount Amount is: "+ discountAmount);
            double total = subTotal-discountAmount;
            System.out.println("The total is: "+ total );
            totalNoOfInvoice +=1;

            System.out.print("Continue (yes/no)-->");
            choice = sc.next();

            if(!choice.equalsIgnoreCase("Yes")){
                choice = sc.nextLine();

                System.out.println("Total Number of Invoice: "+totalNoOfInvoice);
                System.out.println("Average Invoice: "+ total/totalNoOfInvoice);
                System.out.println("Average discounts: "+discounts/totalNoOfInvoice);
            }
        }
    }
    public static double discountValues(double subtotal){
        if(subtotal>=500){
            return 0.25;
        } else if (subtotal>=200) {
            return 0.2;
        } else if (subtotal>=100) {
            return 0.1;
        }else{
            return 0.0;
        }
    }
}
