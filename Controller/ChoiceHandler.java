package Controller;

import Model.Address;
import View.AddressView;
import View.SearchDialog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ChoiceHandler {

    private final List<Address> addressList;
    private final AddressView view;
    private final SearchDialog searchDialog;
    private final String csvFile = "Data/adresses.csv";

    public ChoiceHandler(List<Address> addressList) {
        this.addressList = addressList;
        this.view = new AddressView();
        this.searchDialog = new SearchDialog();
        readAddressesFromCSV();
    }


    // Ruft je nach übernommener Auswahl im Hauptmenü, die entsprechende Methode auf
    public void handleChoice(int choice) {
        switch (choice) {
            case 1 -> view.showAddressList(addressList);
            case 2 -> searchAddress();
            case 3 -> addAddress();
            case 4 -> editAddress();
            case 5 -> deleteAddress();
            default -> System.out.println("Keine gültige Option gewählt");
        }
    }


    // Erstellt je nach Suchkriterium eine Ergebnisliste und gibt sie an showAddressList weiter
    private void searchAddress() {
        int criteria = searchDialog.getSearchCriteria();
        String input = searchDialog.getSearchInput();
        List<Address> results = new ArrayList<>();

        for (Address address : addressList) {
            switch (criteria) {
                case 1 -> { if (address.getVorname().equalsIgnoreCase(input)) results.add(address);}
                case 2 -> { if (address.getNachname().equalsIgnoreCase(input)) results.add(address);}
                case 3 -> { if (address.getAdresse().equalsIgnoreCase(input)) results.add(address);}
                case 4 -> { if (address.getPlz().equalsIgnoreCase(input)) results.add(address);}
                case 5 -> { if (address.getStadt().equalsIgnoreCase(input)) results.add(address);}
                case 6 -> { if (address.getTelefonnummer().equalsIgnoreCase(input)) results.add(address);}
                default -> System.out.println("Keine gültige Option gewählt!");
            }
        }
        view.showAddressList(results);
    }


    // Ruft getAddressInput auf, fügt das Objekt der Adressliste hinzu und schreibt sie in die csv-Datei.
    private void addAddress() {
        Address newAddress = view.getAddressInput();
        addressList.add(newAddress);
        writeAddressesToCSV();
        view.showMessage("Adresse hinzugefügt.");
    }


    // Ruft per Indexzahl die passende Adresse auf, startet getAddressInput und schreibt die csv-Datei
    private void editAddress() {
        int index = view.getIndexInput(addressList.size());
        if (index != -1) {
            Address updateAddress = view.getAddressInput();
            addressList.set(index, updateAddress);

            writeAddressesToCSV();

            view.showMessage("Adresse aktualisiert!");

        } else {
            view.showMessage("Kein Eintrag mit dieser Nummer gefunden.");
        }
    }


    // Fragt über getIndexInput nach dem zu löschenden Datensatz, löscht ihn aus der Liste und schreibt sie in die
    // csv-Datei
    private void deleteAddress() {
        int index = view.getIndexInput(addressList.size());
        if (index != -1) {
            addressList.remove(index);
            writeAddressesToCSV();
            view.showMessage("Adresse gelöscht.");
        } else {
            view.showMessage("Ungültige Auswahl.");
        }
    }


    // Liest eine CSV-Datei mit Adressen ein und befüllt die Liste addressList mit Address-Objekten
    private void readAddressesFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Erste Zeile überspringen
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 6) {
                    addressList.add(new Address(data[0], data[1], data[2], data[3], data[4], data[5]));
                }
            }
            System.out.printf("%d Einträge aus csv-Datei erfolgreich geladen\n", addressList.size());
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Datei: " + e.getMessage());
        }
    }


    // Schreibt die Liste addressList in die csv-Datei
    private void writeAddressesToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            writer.write("Vorname,Nachname,Adresse,PLZ,Stadt,Telefonnummer\n"); // Header hinzufügen
            for (Address address : addressList) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s%n",
                        address.getVorname(), address.getNachname(),
                        address.getAdresse(), address.getPlz(),
                        address.getStadt(), address.getTelefonnummer()));
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Datei: " + e.getMessage());
        }
    }

}
