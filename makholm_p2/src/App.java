import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Unedited Main Function
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput() {
        Scanner in = new Scanner(System.in);
        boolean returnVar = false;
        // Initial input validity check
        System.out.println("Would you like to continue providing input? (Y/N)");
        String userIn = in.next();
        if(userIn.charAt(0) == 'N')
            returnVar = false;
        else if(userIn.charAt(0) == 'Y')
            returnVar = true;
        // Invalid input while loop
        else{
            while(userIn.charAt(0) != 'N' || userIn.charAt(0) != 'Y'){
                System.out.println("Please choose \"Y\" or \"N\" to continue, or stop providing input");
                userIn = in.next();
                if(userIn.charAt(0) == 'Y' || userIn.charAt(0) == 'N')
                    if(userIn.charAt(0) == 'N'){
                        returnVar = false;
                        break;
                    }
                    else if(userIn.charAt(0) == 'Y') {
                        returnVar = true;
                        break;
                    }
            }
        }
        return returnVar;
    }

    private static double getUserHeight(){
        Scanner in = new Scanner(System.in);
        String height = "";
        System.out.println("Please enter your height in inches: ");
        height = in.nextLine();
        while(Double.parseDouble(height) < 0){
            System.out.println("Please reinput your height in inches with a positive value:");
            height = in.nextLine();
        }
        return Double.parseDouble(height);
    }

    private static double getUserWeight(){
        Scanner in = new Scanner(System.in);
        String weight = "";
        System.out.println("Please enter your weight in pounds: ");
        weight = in.nextLine();
        while(Double.parseDouble(weight) < 0) {
            System.out.println("Please reinput your weight in pounds with a positive value:");
            weight = in.nextLine();
        }
        return Double.parseDouble(weight);
    }

    private static void displayBmiInfo(BodyMassIndex bmi){
        System.out.printf("BMI: %.2f \n", bmi.getBmi());
        System.out.println("You are " + bmi.getCategory(bmi.getBmi()));
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        int i = 0; // to access the variable outside of the for loop
        double total = 0;
        for(i = 0; i < bmiData.size(); i++)
            total += bmiData.get(i).getBmi();
        double average = total/Double.parseDouble(String.valueOf(i));
        System.out.print("The Body Mass Index Average of all of the data is: ");
        System.out.printf("%.2f \n", average);
    }
}