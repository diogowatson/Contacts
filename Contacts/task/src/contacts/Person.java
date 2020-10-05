package contacts;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private String surname;
    private String phoneNumber;
    private final String phoneNumberRegex = "^(\\d{10})|(([\\(]?([0-9]{3})[\\)]?)?[ \\.\\-]?([0-9]{3})[ \\.\\-]([0-9]{4}))$";


    public Person(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(this.phoneNumberRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            this.phoneNumber = phoneNumber;
        }else{
            System.out.println("Wrong number format!");
        }

    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + phoneNumber;
    }

    public static class Builder {
        private String name = "";
        private String surname = "";
        private String phoneNumber = "[no number]";

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build() {
            return new Person(name, surname, phoneNumber);
        }
    }
}
