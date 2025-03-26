package View;

import java.util.Scanner;

public class UserChoice {
    private final int numberOfOptions;

    public UserChoice(int numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }

    public int choose() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("\nWählen Sie eine Option: ");
                int choice = Integer.parseInt(input.nextLine());
                if (choice >= 1 && choice <= numberOfOptions + 1) {
                    return choice;
                } else {
                    System.out.println("Ungültige Auswahl. Bitte geben Sie eine Zahl zwischen 1 und " +
                            (numberOfOptions + 1) +" ein");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte nur Zahlen eingeben.");
            }
        }
    }
}
