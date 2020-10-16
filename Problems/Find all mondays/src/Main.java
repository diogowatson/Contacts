import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        int month = scan.nextInt();

        for (LocalDate date = LocalDate.of(year, month, 1);
             date.isBefore(LocalDate.of(year, month, 1).plusMonths(1));
             date = date.plusDays(1)) {

            if (date.getDayOfWeek().toString().equals("MONDAY")) {
                System.out.println(date);
            }
        }
    }
}