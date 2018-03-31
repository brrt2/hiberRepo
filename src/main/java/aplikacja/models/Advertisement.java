package aplikacja.models;
import javax.persistence.*;

@Entity
public class Advertisement {

    @Id
    private int advertisementId;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    private String text;

    public Advertisement() {
    }

    public Advertisement(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
