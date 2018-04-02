package aplikacja.models;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class AdvertDetails {

    private LocalDate dateCreated = LocalDate.now();
    private String city;
    private String category;

    public AdvertDetails() { }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
