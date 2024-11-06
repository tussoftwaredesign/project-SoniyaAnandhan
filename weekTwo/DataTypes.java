package weekTwo;

import java.util.Scanner;

public class DataTypes {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        double subTotal = 1500;
        final double SALES_TAX = 0.50;

        double discountPercentage = 0.0;
        if(subTotal>1000){
            discountPercentage=.10;
        }else{
            discountPercentage=0.0;
        }
        double discountAmount = subTotal*discountPercentage;
        double beforeSales = discountAmount*SALES_TAX;
        double total = subTotal-beforeSales;
        System.out.println("Subtotal: "+ subTotal);
        System.out.println("Discount Amount: " +discountAmount);
        System.out.println("Before Sales: "+ beforeSales);
        System.out.println("Total: "+total);

    }
}
