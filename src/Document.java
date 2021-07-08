import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

public class Document
{
    private int documentId;
    private LocalDate issuedDate;
    private String issuedPlace;
    private String issueInstitution;
    private City municipality;

    public Document() {
        this.documentId = (int) (Math.random()*10000);
    }

    public long getDocumentId() {
        return documentId;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getIssuedPlace() {
        return issuedPlace;
    }

    public void setIssuedPlace(String issuedPlace) {
        this.issuedPlace = issuedPlace;
    }

    public String getIssueInstitution() {
        return issueInstitution;
    }

    public void setIssueInstitution(String issueInstitution) {
        this.issueInstitution = issueInstitution;
    }

    public City getMunicipality() {
        return municipality;
    }

    public void setMunicipality(City municipality) {
        this.municipality = municipality;
    }

    public Integer getPersonalNo() {
        return 0;
    }
}