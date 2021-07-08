import exceptions.NumberNotInRangeException;
import exceptions.StringEmptyException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static DocumentManager docManager = new DocumentManager();
    public static Scanner user = new Scanner(System.in);

    public static void main(String[] args) throws NumberNotInRangeException, StringEmptyException {
        System.out.println("Sistemi per menaxhimin online te dokumenteve.");

        while (true) {
            showMenu();
        }
    }

    public static void showMenu() throws NumberNotInRangeException, StringEmptyException {
        System.out.println("-------------------------------------");
        System.out.println("Type 1 to Manage birth certificates");
        System.out.println("Type 2 to Manage residence certificates");
        System.out.println("Type 3 to Manage marriage certificates");
        System.out.println("Type 4 to print all certificates");
        System.out.println("Type 5 to print summary of documents");
        System.out.println("Type X to exit");
        System.out.println("-------------------------------------");
        System.out.println("Please choose one of the numbers above:  ");

        String selectedMenu = KeyboardScanner.readString();

        switch (selectedMenu.toLowerCase()) {
            case "1":
                var birthCertifManag = new BirthCertificateDocumentManager(docManager);
                birthCertifManag.showMenu();
                break;
            case "2":
                var residenceCertiManag = new ResidenceCertificateDocumentManager(docManager);
                residenceCertiManag.showMenu();
                break;
            case "3":
                var marriageCertiManag = new MarriageCertificateDocumentManager(docManager);
                marriageCertiManag.showMenu();
                break;
            case "4":
                docManager.printAll();
                break;
            case "5":
                docManager.summary();
                break;
            case "x":
                System.out.println("Ju keni mbyllur sistemin per menaxhimin online te dokumenteve me sukses.");
                System.exit(0);
            default:
                System.out.println("Ju lutem zgjedhni njerin nga opsionet me larte");
                break;
        }
        System.out.println();
        System.out.println("Operacioni eshte kryer.");
    }
}