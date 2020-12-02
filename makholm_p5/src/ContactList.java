import javax.naming.InvalidNameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ContactList {
    private static Scanner in = new Scanner(System.in);
    private ArrayList<ContactItem> list = new ArrayList<>();

    public ContactList(ArrayList<ContactItem> list) {

    }

    public void viewList() {
        System.out.println("Current Tasks\n-------------\n\n");
        for (int i = 0; i < list.size(); i++) {
            String printItem = ("Name : " + list.get(i).getFirstName() + " " + list.get(i).getLastName() + "\nPhone: " + list.get(i).getPhoneNum() + "\nEmail: " + list.get(i).getEmail());
            System.out.print(i + ") " + printItem + "\n\n");
        }
    }

    public String promptforFirstName() {
        System.out.println("First name: ");
        return in.nextLine();
    }

    public String promptforLastName() {
        System.out.println("Last name: ");
        return in.nextLine();
    }

    public String promptforPhoneNumber() {
        System.out.println("Phone Number: ");
        return in.nextLine();
    }

    public String promptforEmailAddress() {
        System.out.println("Email address (x@y.z): ");
        return in.nextLine();
    }


    public String promptNewFirstName(String i) {
        System.out.print("Enter a new first name for contact " + i + ":");
        return in.nextLine();
    }

    public String promptNewLastName(String i) {
        System.out.print("Enter a new last name for contact " + i + ":");
        return in.nextLine();
    }

    public String promptNewPhoneNum(String i) {
        System.out.print("Enter a new phone number for contact " + i + ":");
        return in.nextLine();
    }

    public String promptNewEmail(String i) {
        System.out.print("Enter a new email for contact " + i + ":");
        return in.nextLine();
    }

    public String promptEditIndex() {
        System.out.print("Which contact would you like to edit? ");
        return in.nextLine();
    }

    public String promptDeleteIndex() {
        System.out.print("Which item would you like to delete? ");
        return in.nextLine();
    }

    public int size() {
        return list.size();
    }

    public void add(ContactItem item) {
        list.add(item);
    }

    public void replace(int index, ContactItem item) {
        list.set(index, item);
    }

    public ContactItem get(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index must be positive (including 0)");
        }
        if (i > list.size()) {
            throw new IndexOutOfBoundsException("index exceeds the size of the TaskList");
        }
        return list.get(i);
    }


    public ContactItem remove(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index must be positive (including 0)");
        }
        if (i > list.size()) {
            throw new IndexOutOfBoundsException("index exceeds the size of the TaskList");
        }
        return list.remove(i);
    }

    public void saveList() {
        try {
            Formatter output = new Formatter("contactlist.txt");
            for (int i = 0; i < list.size(); i++) {
                output.format(list.get(i).getFirstName() + ";" + list.get(i).getLastName() + ";" + list.get(i).getPhoneNum() + ";" + list.get(i).getEmail() + "=");
            }
            output.close();
            System.out.println("File saved successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadList(ContactList list, String fileName) throws Throwable {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            readInputToList(reader, list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("File could not be located. Be sure it is in the proper directory");
        }
    }

    private static ContactList readInputToList(Scanner reader, ContactList list) throws InvalidNameException, FileNotFoundException {
        try {
            String rawData = reader.nextLine();
            String[] data = rawData.split("[=]", 0);
            for (int i = 0; i < data.length; i++) {
                String[] indexData = data[i].split(";", 0);
                ContactItem item = new ContactItem(indexData[0], indexData[1], indexData[2], indexData[3]);
                list.add(item);
            }
            reader.close();
            return list;
        }catch(IndexOutOfBoundsException e){
            throw new FileNotFoundException("File could not be located. Be sure it is in the proper directory");
        }
    }

    public String promptForFileName() {
        System.out.println("\nWhat is the name of your load file? ");
        return in.nextLine();
    }
}
