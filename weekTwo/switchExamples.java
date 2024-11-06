package weekTwo;

import java.util.Scanner;

public class switchExamples {

    static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a name:");
		String name = sc.next();

		System.out.println("(Switch Expression)");
		switchExpression(name);

		System.out.println("(Switch Statement)");
		switchStatement(name);


	}

	static void switchExpression(String name) {
        int nLetters = switch (name) {
            case "Jane", "Sean", "Alan", "Paul" -> {
                System.out.println("There are 4 letters in: " + name);
                yield 4;
            }
            case "Janet", "Susan" -> {
                System.out.println("There are 5 letters in: " + name);
                yield 5;
            }
            case "Maaike", "Alison", "Miriam" -> {
                System.out.println("There are 6 letters in: " + name);
                yield 6;
            }
            default -> {
                System.out.println("Unrecognized name: " + name);
                yield -1;
            }
		};
		System.out.println(nLetters);

	}

	int no = 4;

	static void switchStatement(String name) {
		int nLetters;
        switch (name) {
		case "Jane", "Sean", "Alan", "Paul" -> nLetters = 4;
		case "Janet", "Susan" -> nLetters = 5;
		case "Maaike", "Alison", "Miriam" -> nLetters = 6;
		default -> {
			System.out.println("Unrecognized name: " + name);
			nLetters = -1;
		}
		}

		System.out.println(nLetters);

	}

}
