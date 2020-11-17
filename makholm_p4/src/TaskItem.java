import javax.naming.InvalidNameException;

public class TaskItem {
    private String taskTitle = "";
    private String taskDescription = "";
    private String taskDate = "";
    private boolean complete = false;

    public TaskItem(String taskTitle, String taskDescription, String taskDate, boolean complete) throws InvalidNameException {

        if(isTitleValid(taskTitle)){
            this.taskTitle = taskTitle;
        } else{
            throw new InvalidNameException("name is not valid. Must be at lead 1 character long.");
        }

        if(isDescValid(taskDescription)){
            this.taskDescription = taskDescription;
        } else{
            throw new InvalidNameException("description is not valid. must be at least 0 characters");
        }

        if(isDateValid(taskDate)){
            this.taskDate = taskDate;
        } else{
            throw new InvalidNameException("Date is not valid. Please use YYYY-MM-DD");
        }
    }

    private boolean isTitleValid(String title){
        return title.length() >= 1;
    }

    private boolean isDescValid(String desc){
        return desc.length() >= 0;
    }

    private boolean isDateValid(String date){
        if(date.length() <= 0 || isNumeric(date.substring(0,4)) == false)
            return false;
        if(Integer.parseInt(date.substring(0,4)) > 2019 && Integer.parseInt(date.substring(5,7)) > 0 && Integer.parseInt(date.substring(5,7)) <= 12 && Integer.parseInt(date.substring(9,10)) < 31)
            return true;
        else
            return false;
        }

    public String getTaskTitle() { return taskTitle; }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskDate() {
        if(this.isComplete()){
            return ("*** " + this.taskDate);
        }
        else
            return taskDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
