package Week2exercise;

import java.util.Scanner;

public class CapitalLetter {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        char inputChar;
        System.out.print("Enter a letter (a-z A-Z) ---> ");
        inputChar = sc.next().charAt(0);

        if (Character.isLetter(inputChar)){
            if(Character.isUpperCase(inputChar)){
                System.out.println("UpperCase letter entered " + inputChar);
            } else if (Character.isLowerCase(inputChar)) {
                System.out.println("LowerCase letter entered " + inputChar);

            }
        }else{
            System.out.println("The character "+inputChar+" is invalid");
        }


//
//        1.	Write a program called CapitalLetter.
//                Take in a letter (char) from the user.
//                Using methods from the Character wrapper class, determine
//    if the letter entered was a capital letter or not.
//                If the letter is a capital letter output “Capital letter entered”;
//    if a lowercase letter, output “Lowercase letter entered”;
//    otherwise output an error (include the offending character in the error message).


    }
}
