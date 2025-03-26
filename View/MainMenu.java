package View;

import Controller.ChoiceHandler;
import Model.Address;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private final List<String> options;
    private final UserChoice userChoice;
    private final ChoiceHandler choiceHandler;
    private final List<Address> addressList;

    public MainMenu() {
        this.options = MainMenuOptions.options;
        this.userChoice = new UserChoice(options.size());
        this.addressList = new ArrayList<>();
        this.choiceHandler = new ChoiceHandler(addressList);
    }

    public void show() {
        while (true) {
            System.out.println("\n---- Adressverwaltung ----");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.println((options.size() + 1) + ". Beenden");

            int choice = userChoice.choose();
            if (choice == options.size() +1 ) {
                System.out.println("Programm beendet.");
                return;
            }
            choiceHandler.handleChoice(choice);
        }
    }
}
