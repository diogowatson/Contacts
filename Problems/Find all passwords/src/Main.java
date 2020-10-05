import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile("(?<=password:?)\\s*([a-zA-Z0-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            System.out.println(matcher.group().trim());
            found = true;
        }
        if (!found) {
            System.out.println("No passwords found.");
        }
    }
}