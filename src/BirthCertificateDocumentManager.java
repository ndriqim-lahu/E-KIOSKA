import exceptions.NumberNotInRangeException;
import exceptions.StringEmptyException;
import java.time.LocalDate;

public class BirthCertificateDocumentManager
{
    private DocumentManager documentManager;

    public BirthCertificateDocumentManager(DocumentManager manager) {
        this.documentManager = manager;
    }

    public void showMenu() throws NumberNotInRangeException, StringEmptyException {
        System.out.println("-------------------------------------");
        System.out.println("Shtypni 1 për të shtuar çertifikatë të re të lindjes");
        System.out.println("Shtypni 2 për të printuar çertifikatën tuaj të lindjes");
        System.out.println("Shtypni 3 për të modifikuar të dhënat për një person");
        System.out.println("Shtypni 4 për të hequr çertifikatën");
        System.out.println("Shtypni X për të dalë nga sistemi");
        System.out.println("-------------------------------------");
        System.out.println("Ju lutemi zgjidhni një nga numrat e mësipërm: ");

        String selectedMenu = KeyboardScanner.readString();

        switch (selectedMenu) {
            case "1":
                this.createBirthCertificate();
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
        int searchPersonalNo = KeyboardScanner.readInteger();

        BirthCertificate certificate = findBirthCertificate(searchPersonalNo);

        if (certificate == null){
            System.out.println("Çertifikata e këtij personi nuk është gjetur.");
            return;
        }

        documentManager.remove(searchPersonalNo, RemoveType.BIRTH_CERTIFICATE);
        System.out.println("Çertifikata e këtij personi është larguar me sukses.");
    }

    private BirthCertificate findBirthCertificate(int personalNo) {
        for (BirthCertificate doc: documentManager.getBirthCertificates()) {
            if (doc.getPerson().getPersonalNo() == personalNo) {
                return doc;
            }
        }
        return null;
    }


    private void findAndModifyCertificate() {
        System.out.println("Shënoni numrin personal të personit: ");
        var searchPersonalNo = KeyboardScanner.readInteger();

        BirthCertificate certificate = findBirthCertificate(searchPersonalNo);

        if (certificate == null) {
            System.out.println("Çertifikata e këtij personi nuk është gjetur.");
            return;
        }

        System.out.println("Shënoni të dhënat e reja të personit. Lëreni boshe nëse nuk dëshironi që t'i ndryshoni: ");

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

        var personi = certificate.getPerson();

        System.out.println("Çertifikata është përditësuar me sukses.");
    }

    private void findAndPrintCertificate() {
        System.out.println("Shënoni numrin personal të personit: ");
        var searchPersonalNo = KeyboardScanner.readInteger();

        BirthCertificate certificate = findBirthCertificate(searchPersonalNo);

        if (certificate == null) {
            System.out.println("Çertifikata e këtij personi nuk është gjetur.");
            return;
        }

        System.out.println(certificate);
    }

    private void createBirthCertificate() throws NumberNotInRangeException, StringEmptyException {
        System.out.println("Shënoni emrin e personit: ");
        var name = KeyboardScanner.validateInputString("Emri i personit është gabim, ju lutem shënoni përsëri.");

        System.out.println("Shënoni mbiemrin e personit: ");
        var surname = KeyboardScanner.validateInputString("Mbiemri i personit është gabim, ju lutem shënoni përsëri.");

        System.out.println("Shënoni numrin personal të personit: ");
        var personalNo = KeyboardScanner.readInteger();
        if(personalNo <1000000000 || personalNo >2000000000)
            throw new NumberNotInRangeException("Numri i japur nuk është në rangun prej (1,000,000,000) deri (2,000,000,000), ju lutem shënoni përsëri.");

        System.out.println("Shënoni gjininë e personit (M ose F): ");
        var gender = KeyboardScanner.readString();

        System.out.println("Shënoni nacionalitetin e personit (KOSOVAR, TURK, BOSHNJAK, ROM, OSE GORAN): ");
        var nationality = KeyboardScanner.readString();

        System.out.println("Shënoni datën e lindjes së personit (yyyy-mm-dd): ");
        String birthdate = KeyboardScanner.readString();

        System.out.println("Shënoni vendin e lindjes së personit: ");
        String birthplace = KeyboardScanner.readString();
        if(birthdate.equals("") || birthplace.trim().equals(""))
            throw new StringEmptyException("Vendi nuk duhet të jetë i zbrazët.");

        System.out.println("Shënoni emrin e babait: ");
        String father = KeyboardScanner.readString();
        if(father.equals("") || father.trim().equals(""))
            throw new StringEmptyException("Emri nuk duhet të jetë i zbrazët.");

        System.out.println("Shënoni emrin e nënës: ");
        String mother = KeyboardScanner.readString();
        if(mother.equals("") || mother.trim().equals(""))
            throw new StringEmptyException("Emri nuk duhet të jetë i zbrazët.");

        try {
            var person = new Person(name,surname,personalNo,GenderBuild.create(gender), Nationality.valueOf(nationality), LocalDate.parse(birthdate), birthplace);

            var certificate = BirthCertificate.GenerateBirthCertificate(person,father,mother);

            documentManager.add(certificate);
            System.out.println("Çertificata e lindjes është regjistruar me sukses.");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}