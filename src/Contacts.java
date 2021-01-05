import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacts extends Input {
    Input userInput = new Input();

    Path filepath = Paths.get("data", "contacts.txt");

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
        return userInput.getInt("Please type the number that corresponds to your choice.");
    }



    public void contactCLIChoices() throws Exception {
        Boolean userContinue = true;

        do{
            int userSelection = contactsMenu();
            switch(userSelection) {
                case 1:
                    showAllContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exit");
                    userContinue = false;
                    break;
                default:
                    System.out.println("Try selecting a different number.");
            }
            if(userContinue){
                System.out.println();
                userContinue = yesNo("Would you like to continue? (Y/N)");
            }
        }   while(userContinue);
    }
    // display all contacts
    public void showAllContacts() throws IOException {
        List<String> contacts = Files.readAllLines(filepath);
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }


    public void addContact() throws IOException {
        String name = userInput.getString("Please enter a name:");
        String phoneNumber = userInput.getString("Please enter a phone number:");
        Files.write(filepath, Arrays.asList(name.toUpperCase() + " " + phoneNumber), StandardOpenOption.APPEND);
        System.out.println("You have successfully added: " + name + " " + phoneNumber);
        contactsReader.writeToLog("Added new contact " + name);
    }

    public void editContact() throws IOException {
        List<String> contactFileContents = Files.readAllLines(filepath);
        List<String> newList = new ArrayList<>();
        showAllContacts();

        String contact = userInput.getString("Type in the name of the contact you'd like to edit:");
        String name = contact;

        for (String contactInfo : contactFileContents) {
            if(contactInfo.contains(contact)) {
                name = userInput.getString("Please enter a name:");
                String phoneNumber = userInput.getString("Please enter a phone number:");
                newList.add(name + " " + phoneNumber);
                System.out.println("You have successfully edited: " + name + " " + phoneNumber);
                continue;
            }   else{
                newList.add(contactInfo);
            }
        }
        Files.write(filepath, newList);
        if (name.equalsIgnoreCase(contact)) {
            contactsReader.writeToLog("Existing contact " + name + " edited.");
        }   else{
            contactsReader.writeToLog("Changed name of existing contact " + contact + " to " + name);
        }
    }

    public void deleteContact() throws IOException {
        List<String> contactFileContents = Files.readAllLines(filepath);
        List<String> newList = new ArrayList<>();
        showAllContacts();

        String contact = userInput.getString("Type in the name of the contact you'd like to delete:");

        for (String contactInfo : contactFileContents) {
            if(contactInfo.contains(contact)) {
                newList.remove(contactInfo);
                System.out.println("You have successfully deleted " + contact + " from the address book.");
                continue;
            }
            newList.add(contactInfo);
        }
        Files.write(filepath, newList);
        contactsReader.writeToLog("Contact " + contact + " deleted.");

    }

}