/* Class used to calculate the BMI scores and return the value */
public class BodyMassIndex {
    public double bmi;

    public BodyMassIndex(double height, double weight) {
        bmi = 703 * (weight / Math.pow(height, 2));
    }

    public double getBmi() {
        return bmi;
    }

    public String getCategory(double bmi) {
        if (bmi < 18.5)
            return "underweight";
        else if (bmi < 25)
            return "normal weight";
        else if (bmi < 30)
            return "overweight";
        else if (bmi >= 30)
            return "obese";
        return "Error";
    }
}
