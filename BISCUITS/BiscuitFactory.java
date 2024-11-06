package BISCUITS;

public class BiscuitFactory {
    public static void main(String[] args){
        Biscuit biscuitOne = new Biscuit();
        biscuitOne.setBrand("Kimberly");
        biscuitOne.setMaker("Jacobs");
        biscuitOne.setWeight(15);

        System.out.println("Biscuit "+"[Maker="+biscuitOne.getMaker()+", brand="+biscuitOne.getBrand()+", weight="+biscuitOne.getWeight()+"]");

        Biscuit biscuitTwo = new Biscuit("McVities","Digestive",20);
        System.out.println("Biscuit "+"[Maker="+biscuitTwo.getMaker()+", brand="+biscuitTwo.getBrand()+", weight="+biscuitTwo. getWeight()+"]");

        biscuitTwo.setBrand("Cadburys");
        biscuitTwo.setMaker("Wholewheat");
        biscuitTwo.setWeight(25);

        System.out.println("Biscuit "+"[Maker="+biscuitTwo.getMaker()+", brand="+biscuitTwo.getBrand()+", weight="+biscuitTwo.getWeight()+"]");


        System.out.println("Number of Biscuits: "+ Biscuit.getNumberOfBiscuit());


    }
}
