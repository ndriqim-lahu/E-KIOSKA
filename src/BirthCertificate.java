import java.time.LocalDate;

public class BirthCertificate extends Document
{
    private Person person;
    private String personFather;
    private String personMother;

    public BirthCertificate() {
        // default
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonFather() {
        return personFather;
    }

    public void setPersonFather(String personFather) {
        this.personFather = personFather;
    }

    public String getPersonMother() {
        return personMother;
    }

    public void setPersonMother(String personMother) {
        this.personMother = personMother;
    }

    public static BirthCertificate GenerateBirthCertificate(Person person, String personFather, String personMother) {
        var certificate = new BirthCertificate();
        certificate.setPerson(person);
        certificate.setIssuedDate(LocalDate.now());
        certificate.setIssueInstitution("MPB");
        certificate.setMunicipality(City.PRISHTINA);
        certificate.setPersonFather(personFather);
        certificate.setPersonMother(personMother);
        certificate.setIssuedPlace("ARC Prishtine");
        return certificate;
    }

    @Override
    public String toString() {
        return String.format("BirthCertificate Nr %s\nName: %s%nSurname: %s%nPersonalNo: %d%nBirthPlace: %s%nGender: %s%nNationality: %s%nBirthdate: %s%n" +
                        "Issue Date: %s%nIssue Place: %s%nInstitution Name: %s%nMunicipality: %s%nFather Name: %s%nMother Name: %s%n-------------------------------%n",
                this.getDocumentId(),
                this.person.getName(),
                this.person.getSurname(),
                this.person.getPersonalNo(),
                this.person.getBirthPlace(),
                this.person.getGender(),
                this.person.getNationality(),
                this.person.getBirthDate().toString(),
                getIssuedDate(),getIssuedPlace(),getIssueInstitution(),getMunicipality(),
                (this.getPersonFather() != null) ? getPersonFather() : "Ska babe",
                (this.getPersonMother() != null) ? getPersonMother() : "Ska nane");
    }
}