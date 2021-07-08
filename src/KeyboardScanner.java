import java.util.Scanner;

public class KeyboardScanner
{
    public static String readString() {
        var user = new Scanner(System.in);
        return  user.nextLine();
    }

    public static Integer readInteger() {
        var user = new Scanner(System.in);
        return user.nextInt();
    }

    public static String validateInputString(String errorMessage) {
        while (true) {
            var scanner = KeyboardScanner.readString();
            if (!scanner.isEmpty() || !scanner.isBlank()) {
                return scanner;
            }
            else {
                System.out.println(errorMessage);
            }
        }
    }
}