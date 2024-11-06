package weekOne;

import java.util.Scanner;

public class Labinvoice {

    public static void main(String[] args){

        System.out.println("Welcome to Grade Converter");
        Scanner sc = new Scanner(System.in);
        String continueChoice = "Yes";



        while (continueChoice.equalsIgnoreCase("Yes")) {

            System.out.print("Enter a numerical grade: ");
            int grade = sc.nextInt();

            if (grade < 0 && grade > 100) {
                System.out.println("Grade cannot be zero or more than 100!!!!");
            } else {
                String grading = gradeValue(grade);
//                grading = sc.next();
                System.out.println(grading);
            }
            System.out.println("Continue -> Yes or No");

            continueChoice = sc.next();

//            System.out.println("value of choice -> " + continueChoice);

            if(!continueChoice.equalsIgnoreCase("Yes") && !continueChoice.equalsIgnoreCase("No")){
                System.out.println("Invalid Input, enter only Yes or No");
                continueChoice = sc.nextLine();

            }
        }
    }
    //3.	Otherwise the grade is converted to a String (>=85 is A, >=70 is B, >=55 is C, >=40 is D, <40 is “Failed”)
    public static String gradeValue(int grade){

//        System.out.print("inside method");
        if(grade >= 85 ){
            return "A";
        } else if (grade >= 70) {
            return "B";
        } else if (grade >= 55) {
            return "C";
        } else if (grade >=40) {
            return "D";
        }else{
            return "Failed";
        }
    }
}