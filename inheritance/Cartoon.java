package inheritance;

class Art{

    public Art(){
        super();
        System.out.println("Art Constructor");
    }
    public void sketch(){

        System.out.println("Art::sketch()");
    }
    public String toString(){
        return "Art::toString()";

    }
}
class Drawing extends Art{

    public Drawing(){
        super();
        System.out.println("Drawing Constructor");
    }
    public void sketch(){

        System.out.println("Drawing::sketch()");
    }
    public String toString(){
        return "Drawing::toString()";

    }

}


public class Cartoon extends Drawing {

    public Cartoon(){
        super();
        System.out.println("Cartoon Constructor");
    }
    public void sketch(){
        System.out.println("Cartoon::sketch()");
    }
    public void tomAndJerry(){
        System.out.println("Cartoon::tomAndJerry()");
    }
    public void sketchIt(Art a){
        a.sketch();
        tomAndJerry();
    }

    public static void main(String[] args) {
//        Cartoon c = new Cartoon();
//        Art a = new Art();
//        Drawing d = new Drawing();
//        c.sketchIt(d);

        System.out.println("UP Casting");
//        Art a1 = new Art();
//        System.out.println(a1);
////
//        Art a2 = new Drawing();
//        System.out.println(a2);

        Art a3 = new Cartoon();
        System.out.println(a3);

        Drawing d1 = new Drawing();
        System.out.println(d1);

        Drawing d2 = new Cartoon();
        System.out.println(d2);

        Cartoon c1 = new Cartoon();
        System.out.println(c1);

        System.out.println("DownCasting");
        Art a1 = new Drawing();
        a1 = (Drawing) d1;
        System.out.println(d1);

        Art a2 = new Cartoon();
        a2 = (Drawing) d2;
        System.out.println(d2);

        a2 = (Cartoon) c1;
        System.out.println(c1);
        System.out.println(a2);

        Drawing d3 = new Cartoon();
        System.out.println(d3);
//        d3 = (Cartoon) c2;
//        System.out.println(c2);

        Drawing d4 = (Drawing) new Art();
        System.out.println(d4);
        Cartoon c3 = (Cartoon) new Art();
        System.out.println(c3);
        Cartoon c4 = (Cartoon) new Drawing();
        System.out.println(c4);









    }
}