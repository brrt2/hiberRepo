package aplikacja.models;
import javax.persistence.*;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue
    private int advertisementId;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    @Embedded
    AdvertDetails advertDetails;

    public Advertisement() {
    }

    public Advertisement(User user, String text, AdvertDetails advertDetails) {
        this.user = user;
        this.text = text;
        this.advertDetails = advertDetails;
    }

    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AdvertDetails getAdvertDetails() {
        return advertDetails;
    }

    public void setAdvertDetails(AdvertDetails advertDetails) {
        this.advertDetails = advertDetails;
    }
}
