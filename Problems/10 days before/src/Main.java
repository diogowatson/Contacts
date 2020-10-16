import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        String[] splited = input.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(splited[0]),
                Integer.parseInt(splited[1]),
                Integer.parseInt(splited[2]));
        System.out.println(date.minusDays(10));
    }
}