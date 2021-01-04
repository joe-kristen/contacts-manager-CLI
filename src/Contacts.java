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
        int userSelection = contactsMenu();
        // insert a do-while for starting with a yesNo
        switch(userSelection) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                System.out.println("This will be the edit function.");
                break;
            case 4:
                deleteContact();
                contactsReader.writeToLog("Delete function accessed.");
                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Try selecting a different number.");
        }
    }
    // display all contacts
    public void showAllContacts() throws IOException {
         for (int i = 0; i < contactsReader.getFileLines().size(); i++) {
             System.out.println(contactsReader.getFileLines().get(i));
         }
//         contactsMenu();
    }

//    public ArrayList<String> asList(Contact contact){
//        ArrayList<String> newList = new ArrayList<String>();
//        newList.add(contact.getName());
//        newList.add(contact.getPhoneNumber());
//        return newList;
//    }



    // add a contact
//    public void addContact() {
//        String name = userInput.getString("Please enter a name:");
//        System.out.println();
//        String phoneNumber = userInput.getString("Please enter a phone number:");
//        System.out.println();
//        Contact newContact = new Contact(name, phoneNumber);
////        Files.write(filepath, newContact, StandardOpenOption.APPEND);
//        try{
//            Files.write(
//                    filepath,
//                    asList(newContact),
//                    StandardOpenOption.APPEND
//
//            );
//        }   catch(Exception E){
//            System.out.println("Invalid");
//        }
//    }


    public void addContact() throws IOException {
        String name = userInput.getString("Please enter a name:");
        String phoneNumber = userInput.getString("Please enter a phone number:");
        Files.write(filepath, Arrays.asList(name + " " + phoneNumber + "\n"), StandardOpenOption.APPEND);
        System.out.println("You have successfully added: " + name + " " + phoneNumber);
    }

    public void editContact() {

    }

    public void deleteContact() throws IOException {
        List<String> contactFileContents = Files.readAllLines(filepath);
        List<String> newList = new ArrayList<>();
        showAllContacts();

        String contact = userInput.getString("Type in the name of the contact you'd like to delete:");

        for (String contactInfo : contactFileContents) {
            if(contactInfo.contains(contact)) {
                newList.remove(contactInfo);
                continue;
            }
            newList.add(contactInfo);
        }
        Files.write(filepath, newList);
    }

}