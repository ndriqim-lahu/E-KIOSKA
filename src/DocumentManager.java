import java.util.ArrayList;

public class DocumentManager
{
    public DocumentManager() {
        // default
    }

    private ArrayList<Document> personsList = new ArrayList<>();

    private int size = personsList.size();

    public void add(Document doc) {
        personsList.add(doc);
    }

    public void registerNewPerson(Document person) {
        personsList.add(person);
    }

    public int getSize() {
        return personsList.size();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Document findCertificate(int personalNo) {
        for(Document dc: personsList) {
            if(dc instanceof BirthCertificate ) {
                BirthCertificate bc = (BirthCertificate) dc;
                if(bc.getPerson().getPersonalNo() == personalNo)
                    return bc;
            }
            if(dc instanceof ResidenceCertificate) {
                ResidenceCertificate rc = (ResidenceCertificate) dc;
                if(rc.getPerson().getPersonalNo() == personalNo)
                    return rc;
            }
            if(dc instanceof MarriageCertificate) {
                MarriageCertificate mc = (MarriageCertificate) dc;
                if(mc.getPerson1().getPersonalNo() == personalNo || mc.getPerson2().getPersonalNo() == personalNo)
                    return mc;
            }
        }
        return null;
    }

    public void printAll() {
        for(Document doc: personsList)
            System.out.println(doc);
    }

    public void remove(int personalNo, RemoveType type) {
        Document dc = findCertificate(personalNo);

        if(type == RemoveType.MARRIAGE_CERTIFICATE) {
            if(dc != null)
                personsList.remove(dc);
        }
        else if(type == RemoveType.RESIDENCE_CERTIFICATE) {
            if(dc != null)
                personsList.remove(dc);
        }
        else if(type == RemoveType.BIRTH_CERTIFICATE) {
            if(dc != null)
                personsList.remove(dc);
        }
    }

    public ArrayList<BirthCertificate> getBirthCertificates() {
        var birthCertificates = new ArrayList<BirthCertificate>();

        for (Document doc: personsList) {
            if (doc instanceof BirthCertificate)
                birthCertificates.add((BirthCertificate) doc);
        }

        return birthCertificates;
    }

    public ArrayList<ResidenceCertificate> getResidenceCertificates() {
        var residenceCertificates = new ArrayList<ResidenceCertificate>();

        for (Document doc: personsList) {
            if (doc instanceof ResidenceCertificate)
                residenceCertificates.add((ResidenceCertificate) doc);
        }

        return residenceCertificates;
    }

    public ArrayList<MarriageCertificate> getMarriageCertificates() {
        var marriageCertificates = new ArrayList<MarriageCertificate>();

        for (Document doc: personsList) {
            if (doc instanceof MarriageCertificate)
                marriageCertificates.add((MarriageCertificate) doc);
        }

        return marriageCertificates;
    }

    public void summary() {
        int birthCertificates = 0;
        int residenceCertificates = 0;
        int marriageCertificates = 0;

        for (Document doc : personsList) {
            if (doc instanceof BirthCertificate )
                birthCertificates++;
            if(doc instanceof ResidenceCertificate)
                residenceCertificates++;
            if(doc instanceof MarriageCertificate)
                marriageCertificates++;
        }

        System.out.printf("Totali i çertifikatave të regjistruara: %nÇertifikata të lindjes janë: %d%nÇertifikata të vendbanimit janë: %d%nÇertifikata të martesës janë: %d%n",
                birthCertificates,residenceCertificates,marriageCertificates);
    }
}