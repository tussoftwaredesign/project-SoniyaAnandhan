package Week2exercise;

import java.util.Scanner;

public class AsciiValues {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char inputChar;
        //        1.	Write a program called AsciiValues that loops until the user types in ‘x’ (a char).
//        For each character input,
//        output the character itself e.g. A but also its numeric Ascii value
//        i.e. 65 (is the Ascii value for A).
          do{
            System.out.print("Enter a char ('x' to exit)--> ");
            inputChar = sc.next().charAt(0);

            if (inputChar != 'x') {
                int asciiValue = (int) inputChar;
                System.out.println("Character " + inputChar + "AsciiValue " + asciiValue);
            }

        }while (inputChar != 'x');
        System.out.println("Exiting programm.....!!!");
    }
}
