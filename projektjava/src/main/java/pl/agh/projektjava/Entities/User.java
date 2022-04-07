package pl.agh.projektjava.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    @Column(name = "tele_numb")
    String teleNumb;

    String email;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String role;
    
    @Column(nullable = false)
    String password;
    
    // constructors

    public User() {
    }

    public User(Long id, String firstName, String lastName, Address address, String teleNumb, String email, String role, String password) {
        setId(id);setFirstName(firstName);setLastName(lastName);setAddress(address);setTeleNumb(teleNumb);setEmail(email);
        setRole(role);setPassword(password);
    }

    // getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTeleNumb() {
        return this.teleNumb;
    }

    public void setTeleNumb(String teleNumb) {
        this.teleNumb = teleNumb;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
