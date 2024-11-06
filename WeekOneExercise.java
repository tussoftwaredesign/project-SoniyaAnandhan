package weekOne;

import java.util.Scanner;

public class WeekOneExercise {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean result = didOswaldActAlone();
        //System.out.println(result);
        if(result){
            System.out.println("Yes, he acted alone");
        }else{
            System.out.println("No, he didn't");
        }
        WeekOneExercise woe = new WeekOneExercise();
        if(woe.wasOjGuilty()){
            System.out.println("Yes, he was");
        }else{
            System.out.println("No, he wasn't");
        }

        String favFilm = favouriteFilm();
        int rating = filmRating(favFilm);
        System.out.println("The rating for "+favFilm+" is "+rating);
    }
    public static boolean didOswaldActAlone(){
        System.out.println("Is Oswald acted alone (true/false)? ");
        return sc.nextBoolean();
    }
    public boolean  wasOjGuilty(){
        System.out.println("Is OJ Guilty (true/false)? ");
        return sc.nextBoolean();

    }
    public static String favouriteFilm(){
        System.out.println("What is your favourite film? ");
        return sc.next();
    }
    public static int filmRating(String favFilm){
        System.out.println("Enter a rating for "+favFilm+" ?");
        return sc.nextInt();

    }
}
