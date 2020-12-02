import javax.naming.InvalidNameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList {
    private static Scanner in = new Scanner(System.in);
    private ArrayList<TaskItem> list = new ArrayList<>();

    public TaskList(ArrayList<TaskItem> list){

    }

    public void viewList() {
        System.out.println("Current Tasks\n-------------\n\n");
        for(int i = 0; i < list.size(); i++){
            String printItem = list.get(i).getTaskDate() + ": " + list.get(i).getTaskTitle() + ": " + list.get(i).getTaskDescription() + "\n";
            System.out.print(i + ") " + printItem);
        }
    }

    public String promptForDate() {
        System.out.print("Task Due Date (YYYY-MM-DD): ");
        return in.nextLine();
    }

    public String promptForDesc() {
        System.out.print("Task Description: ");
        return in.nextLine();
    }

    public String promptForTitle() {
        System.out.print("Task Title: ");
        return in.nextLine();
    }

    public String promptNewDate(String i) {
        System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + i + ":");
        return in.nextLine();
    }

    public String promptNewTitle(String i) {
        System.out.print("Enter a new title for task " + i +": ");
        return in.nextLine();
    }

    public String promptNewDesc(String i) {
        System.out.print("Enter a new description for task " + i + ": ");
        return in.nextLine();
    }

    public String promptEditIndex() {
        System.out.print("Which item would you like to edit? ");
        return in.nextLine();
    }

    public String promptDeleteIndex() {
        System.out.print("Which item would you like to delete? ");
        return in.nextLine();
    }

    public int size(){
        return list.size();
    }

    public void add(TaskItem item){
        list.add(item);
    }

    public void replace(int index, TaskItem item){ list.set(index, item);}

    public TaskItem get(int i){
        if(i<0){
            throw new IllegalArgumentException("index must be positive (including 0)");
        }
        if(i > list.size()){
            throw new IndexOutOfBoundsException("index exceeds the size of the TaskList");
        }
        return list.get(i);
    }

    public void promptMarkItemComplete() {
        printIncompletedTasks();
        String i = promptForCompleteTask();
        TaskItem listItem = list.get(Integer.parseInt(i));
        markItemComplete(Integer.parseInt(i));
    }

    public void markItemComplete(int i) {
        if(i<0){
            throw new IllegalArgumentException("index must be positive (including 0)");
        }
        if(i > list.size()){
            throw new IndexOutOfBoundsException("index exceeds the size of the TaskList");
        }
        list.get(i).setComplete(true);
    }

    public void markItemIncomplete(int i) {
        if(i<0){
            throw new IllegalArgumentException("index must be positive (including 0)");
        }
        if(i > list.size()){
            throw new IndexOutOfBoundsException("index exceeds the size of the TaskList");
        }
        list.get(i).setComplete(false);
    }

    private String promptForCompleteTask() {
        System.out.println("\nWhich task will you mark as complete? ");
        return in.nextLine();
    }

    public void printIncompletedTasks() {
        System.out.println("\nUncompleted Tasks\n-------------\n\n");
        int j = 0;
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).isComplete()){
                System.out.println(j + ") " + list.get(i).getTaskDate() + ": " + list.get(i).getTaskTitle() + ": " + list.get(i).getTaskDescription());
                j++;
            }
        }
    }

    public void printCompletedTasks() {
        System.out.println("\nCompleted Tasks\n-------------\n\n");
        int j = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isComplete()){
                System.out.println(j + ") " + list.get(i).getTaskDate() + ": " + list.get(i).getTaskTitle() + ": " + list.get(i).getTaskDescription());
                j++;
            }
        }
    }

    public TaskItem remove(int i) {
        if(i<0){
            throw new IllegalArgumentException("index must be positive (including 0)");
        }
        if(i > list.size()){
            throw new IndexOutOfBoundsException("index exceeds the size of the TaskList");
        }
        return list.remove(i);
    }

    public void saveList() {
        try {
            Formatter output = new Formatter("tasklist.txt");
            for(int i = 0; i < list.size(); i++){
                output.format(list.get(i).getTaskDate() + ";" + list.get(i).getTaskTitle() + ";" + list.get(i).getTaskDescription()+";");
            }
            output.close();
            System.out.println("File saved successfully");
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to find the file.");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadList(TaskList list, String fileName) throws Throwable {
        try{
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            readInputToList(reader, list);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            throw new FileNotFoundException("File could not be located. Be sure it is in the proper directory");
        }
    }

    private static TaskList readInputToList(Scanner reader, TaskList list) throws InvalidNameException {
        String rawData = reader.nextLine();
        String[] data = rawData.split("[;]", 0);
        for (int i = 0; i < data.length; i += 3) {
            String date = data[i];
            String title = data[i + 1];
            String desc = data[i + 2];
            if (date.substring(0, 1).equals("*")) {
                date = date.substring(4);
                TaskItem item = new TaskItem(title, desc, date, true);
                item.setComplete(true);
                list.add(item);
            } else {
                TaskItem item = new TaskItem(title, desc, date, false);
                list.add(item);
            }
            reader.close();
        }
        return list;
    }

    public String promptForFileName() {
        System.out.println("\nWhat is the name of your load file? ");
        return in.nextLine();
    }

    public String promptCompleteIndex() {
        System.out.println("\nWhat is the task you wish to complete? ");
        return in.nextLine();
    }

    public String promptIncompleteIndex() {
        System.out.println("\nWhat is the task you wish to mark incomplete? ");
        return in.nextLine();
    }
}
