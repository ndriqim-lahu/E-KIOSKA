import java.time.LocalDate;

public class ResidenceCertificateDocumentManager
{
    private DocumentManager documentManager;

    public ResidenceCertificateDocumentManager(DocumentManager manager) {
        this.documentManager = manager;
    }

    public void showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Shtypni 1 për të shtuar çertifikatë të re të vendbanimit");
        System.out.println("Shtypni 2 për të printuar çertifikatën tuaj të vendbanimit");
        System.out.println("Shtypni 3 për të modifikuar të dhënat për një person");
        System.out.println("Shtypni 4 për të hequr çertifikatën");
        System.out.println("Shtypni X për të dalë nga sistemi");
        System.out.println("-------------------------------------");
        System.out.println("Ju lutemi zgjidhni një nga numrat e mësipërm: ");

        String selectedMenu = KeyboardScanner.readString();

        switch (selectedMenu) {
            case "1":
                this.createResidenceCertificate();
                break;
            case "2":
                this.findAndPrintCertificate();
                break;
            case "3":
                this.findAndModifyCertificate();
                break;
            case "4":
                this.findAndRemoveCertificate();
                break;
            default: return;
        }
    }

    private void findAndRemoveCertificate() {
        System.out.println("Shënoni numrin personal të personit: ");
        var searchPersonalNo = KeyboardScanner.readInteger();

        ResidenceCertificate certificate = findResidenceCertificate(searchPersonalNo);

        if (certificate == null){
            System.out.println("Çertifikata e këtij personi nuk është gjetur.");
            return;
        }

        documentManager.remove(searchPersonalNo, RemoveType.RESIDENCE_CERTIFICATE);
        System.out.println("Çertifikata e këtij personi është larguar me sukses.");

    }

    private ResidenceCertificate findResidenceCertificate(int personalNo) {
        for (ResidenceCertificate doc: documentManager.getResidenceCertificates()) {
            if (doc.getPerson().getPersonalNo() == personalNo) {
                return doc;
            }
        }
        return null;
    }

    private void findAndModifyCertificate() {
        System.out.println("Shënoni numrin personal të personit: ");
        var searchPersonalNo = KeyboardScanner.readInteger();

        ResidenceCertificate certificate = findResidenceCertificate(searchPersonalNo);

        if (certificate == null) {
            System.out.println("Çertifikata e këtij personi nuk është gjetur.");
            return;
        }

        System.out.println("Shënoni të dhënat e reja të personit. Lëreni boshe nëse nuk dëshironi që t'i ndryshoni.");

        System.out.println("Shënoni emrin e personit: ");
        var name = KeyboardScanner.readString();

        System.out.println("Shënoni mbiemrin e personit: ");
        var surname = KeyboardScanner.readString();

        System.out.println("Shënoni numrin personal të personit: ");
        var personalNo = KeyboardScanner.readInteger();

        System.out.println("Shënoni gjininë e personit (M ose F): ");
        var gender = KeyboardScanner.readString();

        System.out.println("Shënoni nacionalitetin e personit (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var nationality = KeyboardScanner.readString();

        System.out.println("Shënoni datën e lindjes së personit (yyyy-mm-dd): ");
        String birthdate = KeyboardScanner.readString();

        System.out.println("Shënoni vendin e lindjes së personit: ");
        String birthplace = KeyboardScanner.readString();

        System.out.println("Shënoni gjendjen aktuale martesore (BEQAR, MARTUAR OSE DIVORCUAR): ");
        String status = KeyboardScanner.readString();

        System.out.println("Shënoni vendbanimin aktual: ");
        String vendBanimiActual = KeyboardScanner.readString();

        var personi = certificate.getPerson();

        System.out.println("Çertifikata është përditësuar me sukses.");
    }

    private void findAndPrintCertificate() {
        System.out.println("Shënoni numrin personal të personit: ");
        var searchPersonalNo = KeyboardScanner.readInteger();

        ResidenceCertificate residenceCertificate = findResidenceCertificate(searchPersonalNo);

        if (residenceCertificate == null) {
            System.out.println("Çertifikata e këtij personi nuk është gjetur.");
            return;
        }

        System.out.println(residenceCertificate);
    }

    private void createResidenceCertificate()  {
        System.out.println("Shënoni emrin e personit: ");
        var name = KeyboardScanner.readString();

        System.out.println("Shënoni mbiemrin e personit: ");
        var surname = KeyboardScanner.readString();

        System.out.println("Shënoni numrin personal të personit: ");
        var personalNo = KeyboardScanner.readInteger();

        System.out.println("Shënoni gjininë e personit (M ose F): ");
        var gender = KeyboardScanner.readString();

        System.out.println("Shënoni nacionalitetin e personit (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var nationality = KeyboardScanner.readString();

        System.out.println("Shënoni datën e lindjes së personit (yyyy-mm-dd): ");
        String birthdate = KeyboardScanner.readString();

        System.out.println("Shënoni vendin e lindjes së personit: ");
        String birthplace = KeyboardScanner.readString();

        System.out.println("Shënoni emrin e babait: ");
        String father = KeyboardScanner.readString();

        System.out.println("Shënoni emrin e nënës: ");
        String mother = KeyboardScanner.readString();

        System.out.println("Shënoni gjendjen aktuale martesore (BEQAR, MARTUAR OSE DIVORCUAR): ");
        String status = KeyboardScanner.readString();

        System.out.println("Shënoni vendbanimin aktual: ");
        String vendbanimiActual = KeyboardScanner.readString();

      try {
          var person = new Person(name,surname,personalNo,Gender.valueOf(gender),Nationality.valueOf(nationality),LocalDate.parse(birthdate),birthplace);

          var certificate = ResidenceCertificate.GenerateResidenceCertificate(person,Status.valueOf(status),vendbanimiActual,father,mother);

          documentManager.add(certificate);
          System.out.println("Çertificata e vendbanimit është regjistruar me sukses.");
      }
      catch (Exception ex) {
          System.out.println(ex.getMessage());
      }
    }
}