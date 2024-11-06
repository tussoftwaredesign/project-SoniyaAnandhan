import java.util.Scanner;

enum Direction{
NORTH, SOUTH, EAST, WEST
}
public class conditionalLogic {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
       preAndPostDifference();
       booleanLogicShortCircuitOps();
       booleanBitwiseOps();
       compareStrings();
       System.out.println("Enter certification of the film: ");
       int certofFilm = sc.nextInt();
       System.out.println("Enter your age: ");
       int age = sc.nextInt();
       System.out.println(admitToFilm(certofFilm,age));
       ternaryOperator();
       switchVowelOrConsonant();
       ifMonth();
       ifGrade();
       switchMathOperation();
       switchEnumType();
       ifTemperature();
       switchDaysInMonth();



    }
    public static void preAndPostDifference(){
        int x=5;
        int y=10;
        System.out.println("The value of x is:" + x);
        System.out.println("The value of ++x is: "+ ++x);
        System.out.println("The value of x++ is: "+ x++);
        System.out.println("The value of x is: "+ x);

        System.out.println("The value of y is:" + y);
        System.out.println("The value of ++y is: "+ ++y);
        System.out.println("The value of y++ is: "+ y++);
        System.out.println("The value of y is: "+ y);
    }
    public static void booleanLogicShortCircuitOps(){
        System.out.println("Enter a num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter a num2: ");
        int num2 = sc.nextInt();

        if(num1<0 && num2++<0){
            System.out.println("num2: "+num2);

        }else if(num1>0 && num2++>0){
            System.out.println("num2: "+num2);
        }else if(num1==0 || num2++==0){
            System.out.println("num2: "+num2);
        }else if(num1<0 || num2++<0){
            System.out.println("num2: "+num2);
        }
        System.out.println("num2: "+num2);
    }
    public static void booleanBitwiseOps(){
        System.out.println("Enter a num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter a num2: ");
        int num2 = sc.nextInt();

        if(num1<0 & num2++<0){
            System.out.println("num2: "+num2);

        }else if(num1>0 & num2++>0){
            System.out.println("num2: "+num2);
        }else if(num1==0 | num2++==0){
            System.out.println("num2: "+num2);
        }else if(num1<0 | num2++<0){
            System.out.println("num2: "+num2);
        }
        System.out.println("num2: "+num2);
    }
    public static void compareStrings(){
        System.out.println("Enter a name: ");
        String s1 = sc.next();
        System.out.println("Enter a name: ");
        String s2 = sc.next();

        System.out.println("==returns"+ s1==s2);
        System.out.println("==returns "+ (s1==s2));
        System.out.println("Equals() returns: "+ s1.equals(s2));

        String name1 = "Sean";
        String name2 = "Sean";
        System.out.println(name1==name2);

        String name3 = "Jhon";
        String name4 = new String("Jhon");
        System.out.println(name3 == name4);
    }
    public static boolean admitToFilm(int certOfFilm,int age){
        boolean isOk = (age >= certOfFilm) ? true : false;
        return isOk;


    }
    public static void ternaryOperator(){
        boolean isHappy = true;
//        if(isHappy){
//            System.out.println("I am happy");
//
//        }else{
//            System.out.println("I am not happy");
//        }
        String mood = isHappy ? "I am happy" : "I am not happy";
        System.out.println(mood);

        int x=0, y=0, minVal=0;
        System.out.println("Enter a number x: ");
        x = sc.nextInt();
        System.out.println("Enter a number y: ");
        y = sc.nextInt();
        minVal=x<y?x:y;
        System.out.println("MinValue: "+minVal);


    }
    public static void switchVowelOrConsonant(){
        System.out.println("Enter a char: ");
        char letter = sc.next().charAt(0);
        switch(letter){
            case 65: case 'a':
            case 69: case 'e':
            case '\u0049': case 'i':
            case 0b1001111: case 'o':
            case 0x55: case 'u':
                System.out.println(letter +"is a vowel");
                break;
            default:
                System.out.println(letter +" is a consonant");
                break;
        }
    }
    public static void ifMonth() {
        final int JAN = 1, FEB = 2, MAR = 3, APR = 4, MAY = 5, JUN = 6, JULY = 7, AUG = 8, SEP = 9, OCT = 10, NOV = 11, DEC = 12;
        int month = 0;

        System.out.print("Enter a number between(1-12): ");
        try {
            month = sc.nextInt();
            if (month == JAN) {
                System.out.println("January");
            } else if (month == FEB) {
                System.out.println("Febrauary");
            } else if (month == MAR) {
                System.out.println("March");
            } else if (month == APR) {
                System.out.println("April");
            } else if (month == MAY) {
                System.out.println("May");
            } else if (month == JUN) {
                System.out.println("June");
            } else if (month == JULY) {
                System.out.println("July");
            } else if (month == AUG) {
                System.out.println("August");
            } else if (month == SEP) {
                System.out.println("September");
            } else if (month == OCT) {
                System.out.println("October");
            } else if (month == NOV) {
                System.out.println("November");
            } else if (month == DEC) {
                System.out.println("December");
            } else {
                System.out.println("Entry is out of range: " + month);
            }
        }catch(Exception e){
            System.out.println("Exception!");
            e.printStackTrace();
        }

    }
    public static void ifGrade(){
        int mark = 0;
        System.out.println("Enter your mark: ");
        try{
            mark = sc.nextInt();
            if(mark<0 || mark>100){
                System.out.println("Please enter a valid marks "+mark);
            }else{
                if(mark >=70 && mark <=100){
                    System.out.println("A");
                }else if(mark>=60 && mark<=69){
                    System.out.println("B");
                }else if(mark>=50 && mark<=59){
                    System.out.println("C");
                }else if(mark>=40 && mark<=49){
                    System.out.println("D");
                }else{
                    System.out.println("FAIL");
                }
            }
        }catch(Exception e){
            System.out.println("Exception caught!");
            e.printStackTrace();
        }
    }
    public static void switchMathOperation(){
        double answer = 0.0;
        boolean charOK = true;
//        ask the user to input two double numbers, num1 and num2 (sc.nextDouble())
        System.out.println("Enter a number num1: ");
        double num1 = sc.nextDouble();
        System.out.println("Enter a number num2: ");
        double num2 = sc.nextDouble();

        System.out.println("Enter a mathematical char(+,-,*,/): ");
        char operation = sc.next().charAt(0);

      
        switch(operation){
            case '+':{
                answer = num1 + num2;
                break;
            }
            case '-':{
                answer = num1 - num2;
                break;
            }
            case '*':{
                answer = num1 *num2;
                break;
            }
            case '/':{
                if(num2==0){
                    System.out.println("Error: Cann't divide by zero ");
                    charOK=false;
                }else{
                    answer = num1/num2;
                    break;
                }
            } default:{
                System.out.println("Unknown mathematical character!!! "+operation);
            }

        }
        if(charOK){
              System.out.println("The result is: "+answer);
        }
    }
    public static void switchEnumType(){
//        i. declare a Direction reference theWay and initialise it to null
        Direction theWay = null;
//        ii. prompt the user to enter a string to represent the direction (N, S, E or W)
        System.out.println("Enter a direction (N,S,E or W): ");
        String input = sc.nextLine();
//         convert the string entered to uppercase e.g. “n” goes to “N”
        String direction = input.toUpperCase();
      /*  switch on the string variable
1. if its “N” set theWay to Direction.NORTH and then break
2. if its “S” set theWay to Direction.SOUTH and then break
3. if its “E” set theWay to Direction.EAST and then break
4. if its “W” set theWay to Direction.WEST and then break
5. otherwise, output the string entered following by “ is not recognised” */
        switch(direction){
            case "N":{
               theWay = Direction.NORTH;
               break;
            }
            case "S":{
                theWay = Direction.SOUTH;
                break;
            }
            case "E":{
               theWay = Direction.EAST;
               break;
            }
            case "W":{
                theWay = Direction.WEST;
                break;
            } default:{
                System.out.println("Unrecognised string ");
            }
            /*now, switch on theWay
1. if its NORTH output “Santy…” and then break
2. if its SOUTH output “Penguins…” and then break
3. if its EAST output “The land of the rising sun…” and then break
4. if its WEST output “Hollywood…” and then break */
        }
        switch (theWay){
            case NORTH:{
                System.out.println("Santy,,,");
                break;
            }
            case SOUTH:{
                System.out.println("Penguins,,,");
                break;
            }
            case EAST:{
                System.out.println("The land of the rising sun,,,");
                break;
            }
            case WEST: {
                System.out.println("Hollywood,,,");
                break;
            }
        }

    }
    public static void ifTemperature() {
//        a. declare a local variable temperature and initialise it to 0
        int temperature = 0;
//        b. declare the following constants (final int): COLD is 0; MILD is 15; WARM is 20;
//VERY_WARM is 25 and HOT is 30.
        final int COLD = 0;
        final int MILD = 15;
        final int WARM = 20;
        final int VERY_WARM = 25;
        final int HOT = 30;
//         ask the user to enter a temperature (an int)
        System.out.println("Enter a temperature: ");
        temperature = sc.nextInt();
        /*using an if-else if-else structure and the constants declared, code the following:
i. if the temperature is <=0 output “cold”
ii. if the temperature is between 1..14 output “a little cold but ok”
iii. if the temperature is between 15..19 output “mild”
iv. if the temperature is between 20..24 output “warm”
v. if the temperature is between 25..29 output “very warm”
vi. any temperature >30 output “hot”*/

        try{
            if(temperature<=0){
                System.out.println("cold");
            } else if(temperature >=1 && temperature<=14){
                System.out.println("a little cold but ok");
            } else if (temperature >=15 && temperature<=19) {
                System.out.println("mild");
            } else if (temperature>=20 && temperature<=24) {
                System.out.println("warm");
            } else if (temperature>=25 && temperature<=29) {
                System.out.println("very warm");
            } else {
                System.out.println("hot");
            }
//             wrap the sc.nextInt() and the if statement in a try-catch block. In the exception handler (the
//catch block) output “Exception caught” and print the stack trace
        }catch(Exception e){
            System.out.println("Exception caught!!!!!");
            e.printStackTrace();
        }


    }
    public static void switchDaysInMonth(){
//        a. ask the user to enter a year and store in a local variable namely year
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

//        b. ask the user to enter a month (1..12) and store in a local variable namely month
        System.out.println("Enter a month(1-12): ");
        int month = sc.nextInt();

//        c. declare a local variable numDays and initialise it to 0
        int numDays = 0;

//        d. declare constants for the months of the year e.g. final int JAN=1, FEB=2, MAR=3;
        final int JAN=1, FEB=2, MAR=3, APR=4, MAY=5, JUN=6, JUL=7, AUG=8, SEP=9, OCT=10, NOV=11, DEC=12;
        /*e. switch on month:
i. if it’s January, March, May, July, August, October or December then set numDays to
31 and then break
ii. if its April, June, September or November then set numDays to 30 and then break*/

        switch(month){
            case JAN: case MAR: case MAY: case JUL: case AUG: case OCT: case DEC:
                numDays = 31;
                break;
            case APR: case JUN: case SEP: case NOV:
                numDays = 30;
                break;
             /*   iii. if its February we need to figure out if the year is a leap year:
1. if year is a multiple of 400 (use % operator) OR
2. if year is a multiple of 4 AND not a multiple of 100
3. then it’s a leap year i.e. set numDays to 29
4. otherwise set numDays to 28*/
            case FEB:{
                if((year % 400 ==0)||(year % 4 ==0 && year % 100 !=0)){
                    numDays=29;
                    break;
                }else{
                    numDays = 28;
                }

            } default:{
                System.out.println("Invalid month!!!!!");
                return;
            }
        }
        System.out.println("Number of days: "+numDays);

    }


}
