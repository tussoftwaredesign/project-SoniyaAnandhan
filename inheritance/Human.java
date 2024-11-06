package inheritance;

class Human {

    public Human(){
        super();
        System.out.println("Human constructor");
    }
    public String toString(){
        return "Human::toString";
    }
    public String whoAmI(){
        return "Human::toString";
    }
}
class Male extends Human{
    public Male(){
        super();
        System.out.println("Male Constructor");
    }
    public String toString(){
        return "Male::toString";
    }
    public String whoAmI(){
        return "Male::whoAmI";
    }
    public String show(){
        return "I AM A MAN";
    }
}
class Man extends Male{
    public Man(){
        super();
        System.out.println("Man Constructor");
    }
    public String toString(){
        return "Man::toString";
    }


}
class Boy extends Male{
    public Boy(){
        super();
        System.out.println("Boy Constructor");
    }

}
class Female extends Human{
    public Female(){
        System.out.println("Female constructor");
    }
    public String whoAmI(){
        return "Female::whoAmI";
    }
    public String toString(){
        return "Female::toString";
    }

}
class Girl extends Female{
    public Girl(){
        super();
        System.out.println("Girl constructor");
    }
    public String toString(){
        return "Girl::toString";
    }


}
class Woman extends Female{
    public Woman(){
        super();
        System.out.println("Woman Constructor");
    }
    public String toString(){
        return "Woman::toString";
    }
}