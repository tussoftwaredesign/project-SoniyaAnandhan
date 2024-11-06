package weekTwo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class BigdecimalRoudingMode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String choice = "y";

        while (!choice.equalsIgnoreCase("n")) {
            System.out.print("Enter a subtotal: ");
            double subTotal = sc.nextInt();
            double discountPercent = 0.0;
            if (subTotal >= 200)
                discountPercent = .2;
            else if (subTotal >= 500)
                discountPercent = .5;
            else
                discountPercent = 0.0;


            BigDecimal bigDecimalSubTotal = new BigDecimal(Double.toString(subTotal));
            bigDecimalSubTotal = bigDecimalSubTotal.setScale(2, RoundingMode.HALF_UP);
            BigDecimal discountPercentage = new BigDecimal(Double.toString(discountPercent));

            BigDecimal discountAmount = bigDecimalSubTotal.multiply(discountPercentage);
            BigDecimal totalBeforeTax = bigDecimalSubTotal.subtract(discountAmount);
            BigDecimal salesTaxPercent = new BigDecimal(".05");
            BigDecimal salesTax = salesTaxPercent.multiply(totalBeforeTax);
            BigDecimal Total = salesTax.add(totalBeforeTax);

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();

            String message = "SubTotal: " + currency.format(bigDecimalSubTotal) + "\n" +
                    "DiscountPercent: " + percent.format(discountPercentage) + '\n' +
                    "DiscountAmount: " + currency.format(discountAmount) + "\n" +
                    "TotalBeforeTax: " + currency.format(totalBeforeTax) + "\n" +
                    "SalesTax: " + currency.format(salesTax) + "\n" +
                    "Total: " + currency.format(Total) + "\n";

            System.out.println(message);

            System.out.print("Do you want to continue? (y/n) ---> ");
            choice = sc.next();
            System.out.println();
        }
    }
}
