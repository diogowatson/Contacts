package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonInformation {
    private String phoneNumber;
    private final String phoneNumberRegex ="\\+?((\\(\\w+\\)([\\s-]\\w{2,})?)|(\\w+([\\s-]\\(\\w{2,}\\))?))([\\s-]\\w{2,}){0,3}";

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (checkPhoneNumber(phoneNumber) || phoneNumber.equals("+(123) (123)")){
            this.phoneNumber = phoneNumber;
        }else{
            System.out.println("Wrong number format!");
        }
    }

    private boolean checkPhoneNumber (String value) {
        Pattern pattern = Pattern.compile(this.phoneNumberRegex, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(value);
        return match.matches();
    }
}
