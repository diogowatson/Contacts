import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        int day1 = scan.nextInt();
        int day2 = scan.nextInt();
        int day3 = scan.nextInt();

        ArrayList<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.ofYearDay(year, day1));
        dates.add(LocalDate.ofYearDay(year, day2));
        dates.add(LocalDate.ofYearDay(year, day3));

        dates.forEach(e -> System.out.println(e));
    }
}