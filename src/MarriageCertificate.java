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
        return String.format("Marriage Certificate Nr %s\n" +
                        "Name: %s                        Name: %s%n"  +
                        "Surname: %s                  Surname: %s%n" +
                        "PersonalNo: %d              PersonalNo: %d%n" +
                        "BirthPlace: %s                 BirthPlace: %s%n" +
                        "Gender: %s                           Gender: %s%n" +
                        "Nationality: %s                Nationality: %s%n" +
                        "Birthdate: %s               Birthdate: %s%n%n" +
                        "              Marriage Date: %s%n"+
                        "              Issue Date: %s%n" +
                        "              Issue Place: %s%n" +
                        "              Institution Name: %s%n" +
                        "              Municipality: %s%n",
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