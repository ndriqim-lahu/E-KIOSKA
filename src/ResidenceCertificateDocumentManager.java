import java.time.LocalDate;

public class ResidenceCertificateDocumentManager
{
    private DocumentManager documentManager;

    public ResidenceCertificateDocumentManager(DocumentManager manager) {
        this.documentManager = manager;
    }

    public void showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Type 1 to add new residence certificate");
        System.out.println("Type 2 to print your residence certificate");
        System.out.println("Type 3 to modify data for a person");
        System.out.println("Type 4 to remove certificate");
        System.out.println("Type X to exit");
        System.out.println("-------------------------------------");
        System.out.println("Please choose one of the numbers above:  ");

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
        System.out.println("Shenoni numrin personl te personit.");
        var searchPersonalNo = KeyboardScanner.readInteger();

        ResidenceCertificate certificate = findResidenceCertificate(searchPersonalNo);

        if (certificate == null){
            System.out.println("Certifikata e ketij personi nuk eshte gjetur.");
            return;
        }

        documentManager.remove(searchPersonalNo, RemoveType.RESIDENCE_CERTIFICATE);
        System.out.println("Certifikata e ketij personi eshte larguar me sukses.");

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
        System.out.println("Shenoni numrin personl te personit.");
        var searchPersonalNo = KeyboardScanner.readInteger();

        ResidenceCertificate certificate = findResidenceCertificate(searchPersonalNo);

        if (certificate == null) {
            System.out.println("Certifikata e ketij personi nuk eshte gjetur.");
            return;
        }

        System.out.println("Shenoni te dhenat e reja te personit. Leni boshe nese nuk deshironi ti nderroni.");

        System.out.println("Shenoni emrin personit: ");
        var name = KeyboardScanner.readString();

        System.out.println("Shenoni mbiemrin personit: ");
        var surname = KeyboardScanner.readString();

        System.out.println("Shenoni numrin perosnal te personit: ");
        var personalNo = KeyboardScanner.readInteger();

        System.out.println("Shenoni gjinine e personit (M ose F): ");
        var gender = KeyboardScanner.readString();

        System.out.println("Shenoni nacionalitetin e personit (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var nationality = KeyboardScanner.readString();

        System.out.println("Shenoni daten e lindjes se personit (yyyy-mm-dd): ");
        String birthdate = KeyboardScanner.readString();

        System.out.println("Shenoni vendin e lindjes se personit: ");
        String birthplace = KeyboardScanner.readString();

        System.out.println("Shenoni gjendjen martesore aktuale (BEQAR, MARTUAR OSE DIVORCUAR): ");
        String status = KeyboardScanner.readString();

        System.out.println("Shenoni vendbanimin aktual: ");
        String vendBanimiActual = KeyboardScanner.readString();

        var personi = certificate.getPerson();

        System.out.println("Certifikata eshte bere update me sukses.");
    }

    private void findAndPrintCertificate() {
        System.out.println("Shenoni numrin personl te personit.");
        var searchPersonalNo = KeyboardScanner.readInteger();

        ResidenceCertificate residenceCertificate = findResidenceCertificate(searchPersonalNo);

        if (residenceCertificate == null) {
            System.out.println("Certifikata e ketij personi nuk eshte gjetur.");
            return;
        }

        System.out.println(residenceCertificate);
    }

    private void createResidenceCertificate()  {
        System.out.println("Shenoni emrin e personit: ");
        var name = KeyboardScanner.readString();

        System.out.println("Shenoni mbiemrin e personit: ");
        var surname = KeyboardScanner.readString();

        System.out.println("Shenoni numrin personal te personit: ");
        var personalNo = KeyboardScanner.readInteger();

        System.out.println("Shenoni gjinine e personit (M ose F): ");
        var gender = KeyboardScanner.readString();

        System.out.println("Shenoni nacionalitetin e personit (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var nationality = KeyboardScanner.readString();

        System.out.println("Shenoni daten e lindjes se personit (yyyy-mm-dd): ");
        String birthdate = KeyboardScanner.readString();

        System.out.println("Shenoni vendin e lindjes se personit: ");
        String birthplace = KeyboardScanner.readString();

        System.out.println("Shenoni emrin e babait: ");
        String father = KeyboardScanner.readString();

        System.out.println("Shenoni emrin e nenes: ");
        String mother = KeyboardScanner.readString();

        System.out.println("Shenoni gjendjen martesore aktuale (BEQAR, MARTUAR OSE DIVORCUAR): ");
        String status = KeyboardScanner.readString();

        System.out.println("Shenoni vendbanimin aktual: ");
        String vendbanimiActual = KeyboardScanner.readString();

      try {
          var person = new Person(name,surname,personalNo,Gender.valueOf(gender),Nationality.valueOf(nationality),LocalDate.parse(birthdate),birthplace);

          var certificate = ResidenceCertificate.GenerateResidenceCertificate(person,Status.valueOf(status),vendbanimiActual,father,mother);

          documentManager.add(certificate);
          System.out.println("Certificata e vendbanimit eshte regjistruar me sukses.");
      }
      catch (Exception ex) {
          System.out.println(ex.getMessage());
      }
    }
}