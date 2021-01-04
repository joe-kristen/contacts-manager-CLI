import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactTest {

    public static void main(String[] args) throws Exception {

        Input input = new Input();
        Contacts contactsCLI = new Contacts();
        contactsCLI.contactCLIChoices();

        // create new file
//        Path filePath = Paths.get("data", "contacts.txt");
        // need these variables to be static so they can be accessed by methods below (show, add, edit, delete, etc)
        // 'private' added out of habit
        // final was suggested by intelliJ
//        List<Contact> contactList;
//        List<String> contactsInfo = new ArrayList<>();
//        try {
//            contactsInfo = Files.readAllLines(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Contacts.showAllContacts();

//        Contact c1 = new Contact("John Doe", 1234567);
//        Contact c2 = new Contact("Jane Doe", 2345678);
//        Contact c3 = new Contact("Deer Doe", 3456789);
//        Contact c4 = new Contact("Dynamite", 4567890);

//        Contact.showAllContacts(contacts.txt);
    }

}
