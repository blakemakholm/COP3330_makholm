import javax.naming.InvalidNameException;

public class ContactItem {
    private String firstName = "";
    private String lastName = "";
    private String phoneNum = "";
    private String email = "";

    public ContactItem(String firstName, String lastName, String phoneNum, String email) throws InvalidNameException {
        if(isNameValid(firstName) || isNameValid(lastName)){
            this.firstName = firstName;
        } else{
            throw new InvalidNameException("First name is not valid. Must be at least 1 character long.");
        }

        if(isNameValid(lastName) || isNameValid(firstName)){
            this.lastName = lastName;
        } else{
            throw new InvalidNameException("Last name is not valid. must be at least 1 character long");
        }

        if(isPhoneNumValid(phoneNum) || ((isNameValid(firstName) || isNameValid(lastName)))){
            this.phoneNum = phoneNum;
        } else{
            throw new InvalidNameException("Phone Number is not valid. Must be exactly 10 numbers separated with dashes. Ex: (123-456-7890)");
        }

        if(isEmailValid(email) || (isNameValid(firstName) || isNameValid(lastName))){
            this.email = email;
        } else{
            throw new InvalidNameException("Email is not valid. Must contain an @ symbol.");
        }
    }

    private boolean isNameValid(String name){ return (name.length() >= 1); }

    private boolean isPhoneNumValid(String phoneNum){ return phoneNum.length() == 12; }

    private boolean isEmailValid(String email) { return email.contains("@"); }


    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNum() { return phoneNum; }

    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ContactItem{ firstName=" + firstName + ", lastName=" + lastName + ", phoneNum=" + phoneNum + ", email=" + email + '}';
    }

}
