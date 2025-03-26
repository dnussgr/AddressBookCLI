package View;

import Utils.NumberValidator;

import java.util.Scanner;

public class SearchDialog {
    private final Scanner input = new Scanner(System.in);


    public int getSearchCriteria() {
        System.out.println("\nNach welchem Kriterium möchten Sie suchen?");
        System.out.println("""
                1. Vorname
                2. Nachname
                3. Adresse
                4. Postleitzahl
                5. Stadt
                6. Telefonnummer
                """);

        return NumberValidator.validateNumberIntMinMax(input, "Wählen Sie eine Option: ", 1, 6);
    }


    public String getSearchInput() {
        System.out.print("Geben Sie den Suchbegriff ein: ");
        return input.nextLine();
    }
}
