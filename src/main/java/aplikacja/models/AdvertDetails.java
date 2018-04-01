package aplikacja.models;

import javax.persistence.Embeddable;

@Embeddable
public class AdvertDetails {

//    private LocalDate dateCreated = LocalDate.now();
    private String city;
    private String country;

    public AdvertDetails() {
    }

//    public LocalDate getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDate dateCreated) {
//        this.dateCreated = dateCreated;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
