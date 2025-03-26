package View;

import Model.Address;
import Utils.ListToTable;

import java.util.List;
import java.util.Scanner;


public class AddressView {
    private final Scanner input = new Scanner(System.in);

    // Gibt die übergebene List mittels einer ASCII-Tabelle aus
    public void showAddressList(List<Address> addressList) {
        if (addressList.isEmpty()) {
            System.out.println("Keine Adressen gefunden.");
            return;
        }

        // Aufbereitung der Daten für die ASCII-Tabelle, zusätzlich Index
        String[][] tableData = new String[addressList.size() + 1][7];
        tableData[0] = new String[]{"#", "Vorname", "Nachname", "Adresse", "PLZ", "Stadt", "Telefonnummer"};

        for (int i = 0; i < addressList.size(); i++) {
            Address address = addressList.get(i);
            tableData[i + 1] = new String[]{
                    String.valueOf(i + 1),
                    address.getVorname(),
                    address.getNachname(),
                    address.getAdresse(),
                    address.getPlz(),
                    address.getStadt(),
                    address.getTelefonnummer()
            };
        }
        ListToTable.printTable(tableData);
    }


    public Address getAddressInput() {
        System.out.print("Vorname: ");
        String vorname = input.nextLine();

        System.out.print("Nachname: ");
        String nachname = input.nextLine();

        System.out.print("Adresse: ");
        String adresse = input.nextLine();

        String plz;
        while (true) {
            String plzRegex = "^[0-9]{4}$"; // Prüft, ob der String genau 4 Zahlen enthält

            System.out.print("Postleitzahl: ");
            plz = input.nextLine();

            if (plz.matches(plzRegex)) {
                break;
            } else {
                System.out.println("Ungültige Postleitzahl (4 Ziffern). Bitte erneut probieren!");
            }
        }

        System.out.print("Ort: ");
        String stadt = input.nextLine();

        String telefonnummer;
        while (true) {
            System.out.print("Telefonnummer: ");
            telefonnummer = input.nextLine();

            String telefonRegex = "^(\\+?[0-9][0-9 /-]*)$"; // Prüft, ob String nur Zahlen, + (an erster Stelle), / oder
                                                            // Leerzeichen enthält

            if (telefonnummer.matches(telefonRegex)) {
                break;
            } else {
                System.out.println("Ungültige Telefonnummer! Nur Zahlen und '+', '/', und Leerzeichen erlaubt!\n" +
                        "Bitte erneut eingeben.");
            }
        }

        return new Address(vorname, nachname, adresse, plz, stadt, telefonnummer);
    }


    public int getIndexInput(int maxSize) {
        System.out.print("Geben Sie die Nummer der Adresse ein: ");
        int index = Integer.parseInt(input.nextLine()) - 1;
        return (index >= 0 && index < maxSize) ? index: -1;
    }


    public void showMessage(String message) {
        System.out.println(message);
    }
}
