import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class TaskApp {
    private static Scanner input = new Scanner(System.in);

    public static void main() throws Throwable {
        ArrayList<TaskItem> arraylist = new ArrayList<>();
        TaskList list = new TaskList(arraylist);
        askTaskMainMenu(list);
    }

    private static void askTaskMainMenu(TaskList list) throws Throwable {
        System.out.println("Task Menu\n---------\n\n1) create a new task list\n2) load an existing task list\n3) quit");
        String in = input.nextLine();
        if(in.equals("1")){
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
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu");
        return input.nextLine();
    }

    static void interpretUserInput(String userInput, TaskList list) throws Throwable {
        if (userInput.startsWith("1")) {
            list.viewList();
        } else if(userInput.startsWith("2")) {
            int i = 0;
            while (i == 0) {
                try {
                    String title = list.promptForTitle();
                    String desc = list.promptForDesc();
                    String date = list.promptForDate();
                    TaskItem item = new TaskItem(title, desc, date, false);
                    list.add(item);
                    i++;
                } catch (Exception InvalidNameException) {
                    System.out.println("One or more of the inputs were invalid. Please try again.");
                }
            }
        } else if(userInput.startsWith("3")) {
            int i = 0;
            while(i == 0){
                try {
                    boolean complete = false;
                    String index = list.promptEditIndex();
                    String title = list.promptNewTitle(index);
                    String desc = list.promptNewDesc(index);
                    String date = list.promptNewDate(index);
                    if(date.substring(0,1) == "*")
                        complete = true;
                    else
                        complete = false;
                    TaskItem item = new TaskItem(title, desc, date, complete);
                    list.replace(Integer.parseInt(index), item);
                    i++;
            }catch(Exception InvalidNameException){
                System.out.println("One or more of the inputs were invalid. Please try again.");
            }
        }
        } else if(userInput.startsWith("4")) {
            int i = 0;
            while (i == 0) {
                try {
                    String index = list.promptDeleteIndex();
                    list.remove(Integer.parseInt(index));
                    i++;
                } catch (IllegalArgumentException e) {
                    System.out.println("The index inputted was invalid.");
                } catch (Exception IndexOutOfBounds) {
                    System.out.println("The index inputted was out of range.");
                }
            }
        } else if (userInput.startsWith("5")) {
            int i = 0;
            while (i == 0) {
                try {
                    list.printIncompletedTasks();
                    String index = list.promptCompleteIndex();
                    list.markItemComplete(Integer.parseInt(index));
                    i++;
                } catch (IllegalArgumentException e) {
                    System.out.println("The index inputted was invalid.");
                } catch (Exception IndexOutOfBounds) {
                    System.out.println("The index inputted was out of range.");
                }
            }
        } else if (userInput.startsWith("6")) {
            int i = 0;
            while (i == 0) {
                try {
                    list.printCompletedTasks();
                    String index = list.promptIncompleteIndex();
                    list.markItemIncomplete(Integer.parseInt(index));
                    i++;
                } catch (IllegalArgumentException e) {
                    System.out.println("The index inputted was invalid.");
                } catch (Exception IndexOutOfBounds) {
                    System.out.println("The index inputted was out of range.");
                }
            }
        } else if (userInput.startsWith("7")) {
            list.saveList();
        } else if(userInput.startsWith("8")){
            askTaskMainMenu(list);
        }
    }
}
