package Week2exercise;

public class Operators {
    public static void main(String[] args){
        int x=4,w=20,y=-5,z=0;

        System.out.println(++x);
        System.out.println(x++);
        System.out.println(x);
        System.out.println(--x);
        System.out.println(x--);
        System.out.println(x);


        System.out.println(w==x && y!=z);
        System.out.println(w==x || y!=z);
        System.out.println(!(w==(x+z)));

    }
}
