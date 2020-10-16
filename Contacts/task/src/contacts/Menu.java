package contacts;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    private final ArrayList<Person> phoneBook;
    private Scanner scanner;

    public Menu (ArrayList<Person> phoneBook) {
        this.phoneBook = phoneBook;
        this.scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        String option;

        System.out.print("Enter action (add, remove, edit, count, list, exit):");
        option = scanner.next();
        mainOptions(option);
    }

    public void mainOptions (String option) {
        switch (option.toLowerCase().trim()) {
            case "add": add();
            case "remove": remove();
            case "edit": edit();
            case "count": count();
            case "list": listMenu();
            case "exit": exit();
            default: mainMenu();
        }
    }

    public void add() {
        Person person = new Person.Builder().build();

        person.setName(enterName());
        person.setSurname(enterSurname());
        person.setPhoneNumber(enterPhoneNumber());

        this.phoneBook.add(person);
        System.out.println("The record added.");
        mainMenu();
    }

    public void listMenu() {
        if (this.phoneBook.size() > 0) {
            list();
        }else {
            System.out.println("No records found!");
        }
        mainMenu();
    }

    public void list() {
        AtomicInteger count = new AtomicInteger(1);
        this.phoneBook.forEach(person -> {
            System.out.println(count + ". " + person.toString());
            count.getAndIncrement();
        });
    }

    public void remove(){
        //Scanner scanner = new Scanner(System.in);
        if (this.phoneBook.size() > 0) {
            this.list(); // print the menu
            System.out.print("Select a record: ");
            try {
                int record = scanner.nextInt() - 1;
                this.phoneBook.remove(record);
                System.out.println("The record removed!");
            } catch (InputMismatchException e){
                System.out.println("Wrong Input Format!");
            }
        } else {
            System.out.println("No records to remove!");
        }
        mainMenu();
      }

    public void edit() {

        if (this.phoneBook.size() >0){
            this.list();
            System.out.print("Select a record: ");
            int record = scanner.nextInt() - 1;
            Person person = this.phoneBook.get(record);

            System.out.print("Select a field (name, surname, number):");
            String option = scanner.next();
            switch (option.toLowerCase().trim()) {
                case "name":
                    person.setName(enterName());
                    break;
                case "surname":
                    person.setSurname(enterSurname());
                    break;
                case "number":
                    person.setPhoneNumber(enterPhoneNumber());
                    break;
                default:
                    System.out.println("field don't exist. Want to try again (y/n): ");
                    String choice = scanner.next();
                    if (choice.toLowerCase().trim() == "y" || choice.toLowerCase().trim() == "yes"){
                        edit();
                    } else {
                        mainMenu();
                    }
            }
            this.phoneBook.set(record, person);
            System.out.println("The record updated!");

        }else{
            System.out.println("No records to edit!");
        }
        mainMenu();
    }

    public void count() {
        String output = "The record has " +
                this.phoneBook.size() +
                " records";
        System.out.println(output);
        mainMenu();
    }

    public String enterName() {
        System.out.print("Enter the name: ");
        return scanner.next().trim();
    }

    public String enterSurname() {
        System.out.print("Enter the surname: ");
        return scanner.next().trim();
    }

    public String enterPhoneNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        return scan.nextLine();
    }

    public void exit() {
        System.exit(0);
    }
}
