import java.time.LocalDate;

public class MarriageCertificateDocumentManager
{
    private DocumentManager documentManager;

    public MarriageCertificateDocumentManager(DocumentManager manager) {
        this.documentManager = manager;
    }

    public void showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Shtypni 1 për të shtuar çertifikatë të re të martesës");
        System.out.println("Shtypni 2 për të printuar çertifikatën tuaj të martesës");
        System.out.println("Shtypni 3 për të hequr çertifikatën");
        System.out.println("Shtypni X për të dalë nga sistemi");
        System.out.println("-------------------------------------");
        System.out.println("Ju lutemi zgjidhni një nga numrat e mësipërm: ");

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
        System.out.println("Shënoni numrin personal të personit: ");
        var searchPersonalNo = KeyboardScanner.readInteger();

        MarriageCertificate certificate = findMarriageCertificate(searchPersonalNo);

        if (certificate == null){
            System.out.println("Çertifikata e këtij personi nuk është gjetur.");
            return;
        }

        documentManager.remove(searchPersonalNo, RemoveType.MARRIAGE_CERTIFICATE);
        System.out.println("Çertifikata e këtij personi është larguar me sukses.");
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
        System.out.println("Shënoni numrin personal të personit: ");
        var searchPersonalNo = KeyboardScanner.readInteger();

        MarriageCertificate certificate = findMarriageCertificate(searchPersonalNo);

        if (certificate == null) {
            System.out.println("Çertifikata e martesës nuk është gjetur.");
            return;
        }

        System.out.println(certificate);
    }

    private void createMarriageCertificate() {
        System.out.println("Shënoni të dhënat e kërkuara: ");

        System.out.println("Shënoni emrin e personit 1: ");
        var person1Name = KeyboardScanner.readString();

        System.out.println("Shënoni emrin e personit 2: ");
        var person2Name = KeyboardScanner.readString();

        System.out.println("Shënoni mbiemrin e personit 1: ");
        var person1Surname = KeyboardScanner.readString();

        System.out.println("Shënoni mbiemrin e personit 2: ");
        var person2Surname = KeyboardScanner.readString();

        System.out.println("Shënoni numrin personal të personit 1: ");
        var person1PersonalNo = KeyboardScanner.readInteger();

        System.out.println("Shënoni numrin personal të personit 2: ");
        var person2PersonalNo = KeyboardScanner.readInteger();

        System.out.println("Shënoni gjininë e personit 1 (M ose F): ");
        var person1Gender = KeyboardScanner.readString();

        System.out.println("Shënoni gjininë e personit 2 (M ose F): ");
        var person2Gender = KeyboardScanner.readString();

        System.out.println("Shënoni nacionalitetin e personit 1 (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var person1Nationality = KeyboardScanner.readString();

        System.out.println("Shënoni nacionalitetin e personit 2 (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var person2Nationality = KeyboardScanner.readString();

        System.out.println("Shënoni datën e lindjes së personit 1 (yyyy-mm-dd): ");
        String person1Birthdate = KeyboardScanner.readString();

        System.out.println("Shënoni datën e lindjes së personit 2 (yyyy-mm-dd): ");
        String person2Birthdate = KeyboardScanner.readString();

        System.out.println("Shënoni vendin e lindjes së personit 1: ");
        String person1Birthplace = KeyboardScanner.readString();

        System.out.println("Shënoni vendin e lindjes së personit 2: ");
        String person2Birthplace = KeyboardScanner.readString();

       try {
           var person1 = new Person(person1Name,person1Surname,person1PersonalNo,Gender.valueOf(person1Gender),
                   Nationality.valueOf(person1Nationality), LocalDate.parse(person1Birthdate), person1Birthplace);

           var person2 = new Person(person2Name,person2Surname,person2PersonalNo,Gender.valueOf(person2Gender),
                   Nationality.valueOf(person2Nationality), LocalDate.parse(person2Birthdate), person2Birthplace);

           var marriageCertificate = MarriageCertificate.GenerateMarriageCertificate(person1,person2);

           documentManager.add(marriageCertificate);

           System.out.println("Çertificata e martesës është regjistruar me sukses.");
       }
       catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
    }
}