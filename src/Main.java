import exceptions.NumberNotInRangeException;
import exceptions.StringEmptyException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static DocumentManager docManager = new DocumentManager();
    public static Scanner user = new Scanner(System.in);

    public static void main(String[] args) throws NumberNotInRangeException, StringEmptyException {
        System.out.println("<-- Sistemi për Menaxhimin e Dokumenteve -->\n(Menaxhimi i Çertifikatave të Lindjes, Vendbanimit dhe Martesës).");

        while (true) {
            showMenu();
        }
    }

    public static void showMenu() throws NumberNotInRangeException, StringEmptyException {
        System.out.println("-------------------------------------");
        System.out.println("Shtypni 1 për të menaxhuar çertifikatat e lindjes");
        System.out.println("Shtypni 2 për të menaxhuar çertifikatat e vendbanimit");
        System.out.println("Shtypni 3 për të menaxhuar çertifikatat e martesës");
        System.out.println("Shtypni 4 për të printuar të gjitha çertifikatat");
        System.out.println("Shtypni 5 për të printuar përmbledhje të dokumenteve");
        System.out.println("Shtypni X për të dalë nga sistemi");
        System.out.println("-------------------------------------");
        System.out.println("Ju lutemi zgjidhni një nga numrat e mësipërm: ");

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
                System.out.println("Ju keni mbyllur sistemin për menaxhimin e dokumenteve me sukses.");
                System.exit(0);
            default:
                System.out.println("Ju lutemi zgjidhni njërin nga opsionet më lartë.");
                break;
        }
        System.out.println();
        System.out.println("Operacioni është kryer.");
    }
}