package contacts;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person extends CommonInformation{
    private String name;
    private String surname;


    public Person(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
      //  super.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
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

    private boolean hasNumber(String value) {
        return value.matches(".*\\\\d.*");
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
