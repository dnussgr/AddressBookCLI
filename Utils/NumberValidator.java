package Utils;
import java.util.Scanner;

public class NumberValidator {

    public static int validateNumberIntMinMax(Scanner input, String prompt, int min, int max) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                number = input.nextInt();
                input.nextLine();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen " + min + " und " + max + " ein.");
                }
            } else {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
                input.next();
            }
        }
    }
}
