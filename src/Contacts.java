import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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



    public void contactCLIChoices() throws Exception {
        int userSelection = contactsMenu();
        // insert a do-while for starting with a yesNo
        switch(userSelection) {
            case 1:
                showAllContacts();
                break;
            case 2:
                System.out.println("This will be the add function.");
                break;
            default:
                System.out.println("Try selecting a different number.");
        }
    }
    // display all contacts
    public void showAllContacts() throws IOException {
        contactsReader.writeToLog("success1");
         for (int i = 0; i < contactsReader.getFileLines().size(); i++) {
             System.out.println(contactsReader.getFileLines().get(i));
         }
         contactsMenu();
    }
    // add a contact
    public void addContact() {
        String name = userInput.getString("Please enter a name:");
        String phoneNumber = userInput.getString("Please enter a phone number:");
        Contact newContact = new Contact(name, phoneNumber);
        Path filepath = Paths.get("data", "contacts.txt");
//        Files.write(filepath, newContact, StandardOpenOption.APPEND);



    }


}
