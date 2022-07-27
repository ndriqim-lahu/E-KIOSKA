import java.time.LocalDate;

public class MarriageCertificate extends Document
{
    private Person person1;
    private Person person2;
    private LocalDate marriageDate;

    public MarriageCertificate() {
        // default
    }

    public static MarriageCertificate GenerateMarriageCertificate(Person person1, Person person2) {
        var certificate = new MarriageCertificate();
        certificate.setPerson1(person1);
        certificate.setPerson2(person2);
        certificate.setIssuedDate(LocalDate.now());
        certificate.setMarriageDate(LocalDate.now());
        certificate.setIssueInstitution("MPB");
        certificate.setMunicipality(City.PRISHTINA);
        certificate.setIssuedPlace("ARC Prishtine");
        return certificate;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    @Override
    public String toString() {
        return String.format("Nr i çertifikatës së martesës %s\n" +
                        "Emri: %s                        Emri: %s%n"  +
                        "Mbiemri: %s                     Mbiemri: %s%n" +
                        "Numri Personal: %d              Numri Personal: %d%n" +
                        "Vendlindja: %s                  Vendlindja: %s%n" +
                        "Gjinia: %s                      Gjinia: %s%n" +
                        "Nacionaliteti: %s               Nacionaliteti: %s%n" +
                        "Data e lindjes: %s              Data e lindjes: %s%n%n" +
                        "              Data e martesës: %s%n"+
                        "              Data e lëshimit: %s%n" +
                        "              Vendi i lëshimit: %s%n" +
                        "              Emri i Institucionit: %s%n" +
                        "              Komuna: %s%n",
                this.getDocumentId(),
                this.person1.getName(),this.person2.getName(),
                this.person1.getSurname(),this.person2.getSurname(),
                this.person1.getPersonalNo(),this.person2.getPersonalNo(),
                this.person1.getBirthPlace(),this.person2.getBirthPlace(),
                this.person1.getGender(),this.person2.getGender(),
                this.person1.getNationality(),this.person2.getNationality(),
                this.person1.getBirthDate().toString(),this.person2.getBirthDate().toString(),getMarriageDate(),
                getIssuedDate(),getIssuedPlace(),getIssueInstitution(),getMunicipality());
    }
}