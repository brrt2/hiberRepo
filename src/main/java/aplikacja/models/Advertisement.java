package aplikacja.models;
import javax.persistence.*;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int advertisementId;

//    @ManyToOne
//    @JoinColumn(name = "username")
//    private User user;

    private String username;

    private String text;

    public Advertisement() {
    }

    public Advertisement(String username, String text) {
        this.username = username;
        this.text = text;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
