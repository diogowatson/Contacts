package contacts;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    private ArrayList<Person> phoneBook;

    public Menu (ArrayList<Person> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void create() {
        do {

        }
    }

    public void mainMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter action (add, remove, edit, count, list, exit):");

    }

    public void add() {
        Person person = new Person.Builder().build();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        person.setName(name);

        System.out.print("Enter the surname: ");
        String surname = scanner.nextLine();
        person.setSurname(surname);

        System.out.println("Enter the number: ");
        String phoneNumber = scanner.nextLine();
        person.setPhoneNumber(phoneNumber);

        this.phoneBook.add(person);
        System.out.println("The record added.");
    }

    public void list() {
        AtomicInteger count = new AtomicInteger(1);
        this.phoneBook.forEach(person -> {
            System.out.println(count + ". " + person.toString());
            count.getAndIncrement();
        });
    }

    public void remove(){
        Scanner scanner = new Scanner(System.in);

        this.list(); // print the menu
        System.out.print("Select a record: ");
        int record = scanner.nextInt() - 1;
        this.phoneBook.remove(record);
        System.out.println("The record removed!");
        //TODO - create list record first
    }
}
