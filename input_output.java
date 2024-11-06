import java.util.InputMismatchException;
import java.util.Scanner;

public class input_output {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int age = getAge();
        System.out.println("The age entered is: "+age);

        int age1 = getAge("Enter your age: ");
        System.out.println("The age entered is: "+age1);

        int age2 = getAge("What is your age? ","Soniya");
        System.out.println("The age entered is: "+age2);
        boolean  canGetPension = checkPension(100);
        if(canGetPension){
            System.out.println("Eligible for pension");
        }else{
            System.out.println("Not eligible for pension");
        }
        String name = getName();
        System.out.println(name);
        String []name1 = new String[2];
        getName(name1);
        for (int i=0;i<name1.length;i++) {
            System.out.println(name1[i]);
        }

    }
    public static int getAge(){
        int age =0;

        System.out.println("What is your age? ");
        age = sc.nextInt();
        return age;
    }

    public static int getAge(String prompt){
        int age=0;
        try{
            System.out.println(prompt);
            age = sc.nextInt();
        }catch (InputMismatchException ime){
            ime.printStackTrace();
        }
        return age;

    }
    public static int getAge(String prompt, String name){
        int age = 0;

        System.out.println("Hi there "+name+", "+prompt);
        if(sc.hasNextInt()){
            age = sc.nextInt();
        }else{
            System.err.println("Error in the input.");
            age = -999;
        }
        return age;
    }
    public static boolean checkPension(int age) {
        if(age>=65){
            return true;
        }else{
            return false;
        }
    }
    public static String getName(){
        System.out.print("Enter your name -----> ");
        String name = sc.nextLine();
        return name;

    }

    public static void getName(String []name){
        System.out.print("Enter your name -----> ");
        name[0] = sc.next();
        name[1] = sc.next();
    }
}
