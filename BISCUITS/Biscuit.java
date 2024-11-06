package BISCUITS;

public class Biscuit {

    private static int getNumberOfBiscuit=0;
    private int weight;
    private String brand;
    private String maker;

    public Biscuit() {
        getNumberOfBiscuit++;


    }
    public Biscuit(String brand, String maker, int weight){
        this.brand = brand;
        this.maker = maker;
        this.weight = weight;
        getNumberOfBiscuit++;
    }
    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static int getNumberOfBiscuit() {
        return getNumberOfBiscuit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public String toString() {
        return super.toString();

    }
//    public boolean isOutOfDate(){
//        return ;

}