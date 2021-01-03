import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Contacts extends Input {
    Input userInput = new Input();

    FileIO contactsReader = new FileIO("data", "contacts.txt", "contacts.log");

    public Contacts() throws IOException {

    }

    public int contactsMenu() {
        System.out.println("**OPENING ADDRESS BOOK**:\n" +
                "(1) View all contacts\n" +
                "(2) Add a contact\n" +
                "(3) Edit a contact\n" +
                "(4) Remove a contact\n" +
                "(5) Exit menu\n");
        return userInput.getInt(1,5, "Please type the number that corresponds to your choice.");
    }


    public void showAllContacts() throws IOException {
        contactsReader.writeToLog("success1");
         for (int i = 0; i < contactsReader.getFileLines().size(); i++) {
             System.out.println(contactsReader.getFileLines().get(i));
         }
         contactsMenu();
    }

    public void contactCLIChoices() throws Exception {
        int userSelection = contactsMenu();

        switch(userSelection) {
            case 1:
                showAllContacts();
                break;
            case 2:
                System.out.println("This case is working.");
                break;
            default:
                System.out.println("Try selecting a different number.");
        }
    }


}
