import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Throwable {
        System.out.println("Select Your Application\n---------\n\n1) task list\n2) contact list\n3) quit");
        int i = 0;
        while(i == 0){
            String in = input.nextLine();
            if(in.equals("1")){
                i++;
                TaskApp.main();
            }
            else if(in.equals("2")){
                i++;
                ContactApp.main();
            }
            else if(in.equals("3")){
                i++;
                System.exit(0);
            }
    }
}}
