import java.util.Scanner;


public class METHODS {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter a X value: ");
        int X = sc.nextInt();
        System.out.print("Enter a Y value: ");
        int Y = sc.nextInt();
        int Sum = calculateSum(X,Y);
        System.out.println("The sum of " +X+ " and " +Y+ " is "+ Sum );
        int Diff = calculateDiff(X,Y);
        System.out.println("The diff of " +X+ " and " +Y+ " is "+ Diff);
        int Multi = calculateMulti(X,Y);
        System.out.println("The multi of " +X+ " and " +Y+ " is " + Multi);
        int Div = calculateDiv(X,Y);
        System.out.println("The div of " +X+ " and " +Y+ " is " + Div);
        System.out.print("Enter a length of the cylinder: ");
        int length = sc.nextInt();
        System.out.print("Enter a width of the cylinder: ");
        int width = sc.nextInt();
        System.out.print("Enter a height of the cylinder: ");
        int height = sc.nextInt();

        int volume = calcVolume(length,width,height);
        System.out.println(volume);
        coordGeometry();
        System.out.print("Enter the opposite side value: ");
        double opposite = sc.nextDouble();
        System.out.print("Enter the adjacent side value: ");
        double adjacent = sc.nextDouble();

        double hypotenuse = calcHypotenuse(opposite,adjacent);
        System.out.println("The length of the hypotenuse is: " + hypotenuse);

        System.out.print("Enter the Base: ");
        int Base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int Exponent = sc.nextInt();


        System.out.println(Base +" to the power is "+ Exponent + " is " +intPower(Base,Exponent));
        System.out.print("How many numbers want to add?: ");
        int num = sc.nextInt();

        int totalSum = sumTheValues(num);
        System.out.println(totalSum);
         METHODS me = new METHODS();
         int total = me.addNumbers(3,5);
         System.out.println("The addition values are: "+total);

         double volume1 = calcVolume(.7,.8,.9);
         System.out.println("The volume is: " +volume1);

    }

    public static int calculateSum(int X, int Y) {
        return X + Y;
    }

    public static int calculateDiff(int X, int Y) {
        return X - Y;
    }

    public static int calculateMulti(int X, int Y) {
        return X * Y;
    }

    public static int calculateDiv(int X, int Y) {
        if (Y != 0) {
            return X / Y;
        } else {
            System.out.println("Invalid number!!!");
        }
        return X/Y;
    }

    public static int calcVolume(int length, int width, int height){
        return (length*width*height);

    }

    public static void coordGeometry(){
        System.out.print("Please enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Please enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Please enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Please enter y2: ");
        double y2 = sc.nextDouble();

        double distance = calcDistance(x1,x2,y1,y2);
        System.out.println("Distance between the two points is : "+ distance);

        double[] midpoint = calcMidPoint(x1,x2,y1,y2);
        System.out.println("The midpoint is: "+ midpoint[1]);

        double slop = calcSlope(x1,x2,y1,y2);
        if(x1!=x2){
            System.out.println("The slop is: "+slop);
        }else{
            System.out.println("The slop is undefined");

        }

    }
    public static double[] calcMidPoint(double x1 , double x2, double y1, double y2){
        double[] midpoint = new double[2];
        midpoint[0] = (x1+x2)/2;
        midpoint[1] = (y1+y2)/2;
        return midpoint;


    }
    public static double  calcDistance(double x1,double y1,double x2, double y2){
        return Math.sqrt(Math.pow((y2-y1),2) + Math.pow((x2-x1),2));
    }
    public static double calcSlope(double x1, double x2, double y1, double y2){

        return (y2-y1)/(x2-x1);
    }

    public static double calcHypotenuse(double opposite, double adjacent) {
        return Math.sqrt(Math.pow(opposite, 2) + Math.pow(adjacent, 2));
    }

    public static int intPower(int Base,int Expo) {
        int i = 0, total = 1;

        for (i = 1; i <= Expo; i++) {
            total *= Base;
        }
        return total;

    }
    public static int sumTheValues(int n){
        int total = 0;

        for (int i=0;i<n;i++){
            System.out.print("Enter a number "+ (i+1)+ " :  " );
            int value = sc.nextInt();
            total += value;
        }
        return total;
    }


    public int addNumbers(int num1, int num2){
        return num1+num2;
    }
    public static double calcVolume(double length, double width, double height){
        return length*width*height;
    }


}