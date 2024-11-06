package weekTwo;

import java.util.Scanner;

public class switchExercise {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Enter a name---> ");
        String name = sc.nextLine();

        switchExpression(name);
        switchStatement(name);



    }
    static void switchExpression(String name){
        int nLetter = switch(name){
            case "Sagu","Mary","Moon","Cool"->{
                System.out.println("There are 4 letters in "+ name);
                yield 4;
            }
            case "Jeshu","Mathi","Anand","Sonia"->{
                System.out.println("There are 5 letters in "+ name);
                yield 5;
            }
            case "Soniya","Mariam","Jennet","Murali"->{
                System.out.println("There are 6 letters in "+ name);
                yield 6;
            }default -> {
                System.out.println("There is no name "+name);
                yield -1;
            }
        };
        System.out.println(nLetter);
    }
    static void switchStatement(String name){
        int nLetter;
        switch(name){
            case "Sagu","Mary","Moon","Cool"->nLetter = 4;
            case "Jeshu","Mathi","Anand","Sonia"->nLetter=5;
            case "Soniya","Mariam","Jennet","Murali"->nLetter=6;
            default -> {
                System.out.println("Unrecognise name!!! "+name);
                nLetter=-1;
            }
        }
        System.out.println(nLetter);
    }
}
