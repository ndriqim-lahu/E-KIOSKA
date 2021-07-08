import java.time.LocalDate;

public class MarriageCertificateDocumentManager
{
    private DocumentManager documentManager;

    public MarriageCertificateDocumentManager(DocumentManager manager) {
        this.documentManager = manager;
    }

    public void showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Type 1 to add new marriage certificate");
        System.out.println("Type 2 to print your marriage certificate");
        System.out.println("Type 3 to remove certificate");
        System.out.println("Type X to exit");
        System.out.println("-------------------------------------");
        System.out.println("Please choose one of the numbers above:  ");

        String selectedMenu = KeyboardScanner.readString();

        switch (selectedMenu) {
            case "1":
                this.createMarriageCertificate();
                break;
            case "2":
                this.findAndPrintCertificate();
                break;
            case "3":
                this.findAndRemoveCertificate();
                break;
            default: return;
        }
    }

    private void findAndRemoveCertificate() {
        System.out.println("Shenoni numrin personl te personit.");
        var searchPersonalNo = KeyboardScanner.readInteger();

        MarriageCertificate certificate = findMarriageCertificate(searchPersonalNo);

        if (certificate == null){
            System.out.println("Certifikata e ketij personi nuk eshte gjetur.");
            return;
        }

        documentManager.remove(searchPersonalNo, RemoveType.MARRIAGE_CERTIFICATE);
        System.out.println("Certifikata e ketij personi eshte larguar me sukses.");
    }

    private MarriageCertificate findMarriageCertificate(int personalNo) {
        for (MarriageCertificate doc: documentManager.getMarriageCertificates()) {
            if (doc.getPerson1().getPersonalNo() == personalNo) {
                return doc;
            }
        }
        return null;
    }

    private void findAndPrintCertificate() {
        System.out.println("Shenoni numrin personl te personit.");
        var searchPersonalNo = KeyboardScanner.readInteger();

        MarriageCertificate certificate = findMarriageCertificate(searchPersonalNo);

        if (certificate == null) {
            System.out.println("Certifikata e marteses nuk eshte gjetur.");
            return;
        }

        System.out.println(certificate);
    }

    private void createMarriageCertificate() {
        System.out.println("Sheno te dhenat e kerkuara: ");

        System.out.println("Shenoni emrin personit 1: ");
        var person1Name = KeyboardScanner.readString();

        System.out.println("Shenoni emrin personit 2: ");
        var person2Name = KeyboardScanner.readString();

        System.out.println("Shenoni mbiemrin personit 1: ");
        var person1Surname = KeyboardScanner.readString();

        System.out.println("Shenoni mbiemrin personit 2: ");
        var person2Surname = KeyboardScanner.readString();

        System.out.println("Shenoni numrin personal te personit 1: ");
        var person1PersonalNo = KeyboardScanner.readInteger();

        System.out.println("Shenoni numrin personal te personit 2: ");
        var person2PersonalNo = KeyboardScanner.readInteger();

        System.out.println("Shenoni gjinine e personit 1 (M ose F): ");
        var person1Gender = KeyboardScanner.readString();

        System.out.println("Shenoni gjinine e personit 2 (M ose F): ");
        var person2Gender = KeyboardScanner.readString();

        System.out.println("Shenoni nacionalitetin e personit 1 (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var person1Nationality = KeyboardScanner.readString();

        System.out.println("Shenoni nacionalitetin e personit 2 (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var person2Nationality = KeyboardScanner.readString();

        System.out.println("Shenoni daten e lindjes se personit 1 (yyyy-mm-dd): ");
        String person1Birthdate = KeyboardScanner.readString();

        System.out.println("Shenoni daten e lindjes se personit 2 (yyyy-mm-dd): ");
        String person2Birthdate = KeyboardScanner.readString();

        System.out.println("Shenoni vendin e lindjes se personit 1: ");
        String person1Birthplace = KeyboardScanner.readString();

        System.out.println("Shenoni vendin e lindjes se personit 2: ");
        String person2Birthplace = KeyboardScanner.readString();

       try {
           var person1 = new Person(person1Name,person1Surname,person1PersonalNo,Gender.valueOf(person1Gender),
                   Nationality.valueOf(person1Nationality), LocalDate.parse(person1Birthdate), person1Birthplace);

           var person2 = new Person(person2Name,person2Surname,person2PersonalNo,Gender.valueOf(person2Gender),
                   Nationality.valueOf(person2Nationality), LocalDate.parse(person2Birthdate), person2Birthplace);

           var marriageCertificate = MarriageCertificate.GenerateMarriageCertificate(person1,person2);

           documentManager.add(marriageCertificate);

           System.out.println("Certificata e marteses eshte regjistruar me sukses.");
       }
       catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
    }
}