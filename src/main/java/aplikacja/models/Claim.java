package aplikacja.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Claim {

    @Id
    @GeneratedValue
    private int claimId;

    @Column(name="name")
    @NotBlank
    @Size(min=3, max=30)
    private String name;

    @Email
    private String email;

    @Size(min=3, max=30)
    @NotBlank
    private String policyId;

    @NotBlank
    private String claimType;

    @NotBlank
    @Size(min=1, max=20)
    private String claimAmount;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    public Claim() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(String claimAmount) {
        this.claimAmount = claimAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
