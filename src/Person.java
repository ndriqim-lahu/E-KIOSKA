import java.time.LocalDate;

public class Person
{
    private String name;
    private String surname;
    private int personalNo;
    private Gender gender;
    private Nationality nationality;
    private LocalDate birthDate;
    private String birthPlace;

    public Person(String name, String surname, int personalNo, Gender gender, Nationality nationality, LocalDate birthDate, String birthPlace) throws Exception {
        setName(name);
        setSurname(surname);
        setPersonalNo(personalNo);
        setGender(gender);
        setNationality(nationality);
        setBirthDate(birthDate);
        setBirthPlace(birthPlace);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.isEmpty() || name.isBlank())
            throw new Exception("Emri nuk duhet të qëndrojë i zbrazët.");
        else{
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws Exception {
        if(surname.isEmpty() || surname.isBlank())
            throw new Exception("Mbiemri nuk duhet të qëndrojë i zbrazët.");
        else{
            this.surname = surname;
        }
    }

    public int getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(int personalNo) throws Exception {
        if (personalNo > 999999999 && personalNo <2000000000) {
            this.personalNo = personalNo;
        }
        else {
            throw new Exception("Numri personal duhet të shënohet me shifra.");
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
}