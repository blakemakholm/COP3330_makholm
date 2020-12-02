import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class ContactApp {
    private static Scanner input = new Scanner(System.in);

    public static void main() throws Throwable {
        ArrayList<ContactItem> arraylist = new ArrayList<>();
        ContactList list = new ContactList(arraylist);
        askContactMainMenu(list);
    }

    private static void askContactMainMenu(ContactList list) throws Throwable {
        System.out.println("Contact Menu\n---------\n\n1) create a new contact list\n2) load an existing contact list\n3) quit");
        String in = input.nextLine();
        if(in.equals("1")){
            System.out.println("New contact list has been created.");
            String userInput = "";
            while(true) {
                userInput = askListInput();
                interpretUserInput(userInput, list);
            }
        }
        else if(in.equals("2")){
            list.loadList(list, list.promptForFileName());
            System.out.println("Contact list has been loaded.");
            String userInput = "";
            while(true) {
                userInput = askListInput();
                interpretUserInput(userInput, list);
            }
        }
        else if(in.equals("3")){
            String[] strings = {""};
            App.main(strings);
        }
        else
            throw new IllegalArgumentException();
    }

    private static String askListInput(){
        System.out.println("\nList Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) save the current list\n" +
                "6) quit to the main menu");
        return input.nextLine();
    }

    static void interpretUserInput(String userInput, ContactList list) throws Throwable {
        if (userInput.startsWith("1")){
            list.viewList();
        }
        else if(userInput.startsWith("2")) {
            int i = 0;
            while(i == 0){
                try {
                    String firstName = list.promptforFirstName();
                    String lastName = list.promptforLastName();
                    String phoneNum = list.promptforPhoneNumber();
                    String email = list.promptforEmailAddress();
                    ContactItem item = new ContactItem(firstName, lastName, phoneNum, email);
                    list.add(item);
                    i++;
                }catch(Exception InvalidNameException){
                    System.out.println("One or more of the inputs were invalid. Please try again.");
                }
            }
        }
        else if(userInput.startsWith("3")){
            int i = 0;
            try {
                String index = list.promptEditIndex();
                String firstName = list.promptNewFirstName(index);
                String lastName = list.promptNewLastName(index);
                String phoneNum = list.promptNewPhoneNum(index);
                String email = list.promptNewEmail(index);
                ContactItem item = new ContactItem(firstName, lastName, phoneNum, email);
                list.replace(Integer.parseInt(index), item);
                i++;
            }catch(Exception InvalidNameException){
                System.out.println("One or more of the inputs were invalid. Please try again.");
            }
        }
        else if(userInput.startsWith("4")){
            int i = 0;
            try {
                String index = list.promptDeleteIndex();
                list.get(Integer.parseInt(index));
                list.remove(Integer.parseInt(index));
                i++;
            } catch(IllegalArgumentException e) {
                System.out.println("The index inputted was invalid.");
            } catch(Exception IndexOutOfBounds) {
                System.out.println("The index inputted was out of range.");
            }
        }
        else if(userInput.startsWith("5")){
            list.saveList();
        }
        else if(userInput.startsWith("6")){
            askContactMainMenu(list);
        }
    }
}
