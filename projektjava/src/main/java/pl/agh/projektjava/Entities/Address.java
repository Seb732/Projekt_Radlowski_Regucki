package pl.agh.projektjava.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String city;

    @Column(name = "postal_code")
    String postalCode;

    String street;

    @Column(name = "building_numb")
    String buildingNumb;

    @Column(name = "local_numb")
    String localNumb;

    @OneToMany(mappedBy = "address")
    Set<User> users;

    @OneToMany(mappedBy = "address")
    Set<Client> clients;
    
    // @OneToMany(mappedBy="address")
    // Set<CompanyClient> companyClients;
    
    // @OneToMany(mappedBy = "address")
    // Set<PersonalClient> personalClients;

    // Constructors

    public Address() {
    }

    public Address(Long id, String city, String postalCode, String street, String buildingNumb, String localNumb) {
        setId(id);setCity(city);setPostalCode(postalCode);setStreet(street);setBuildingNumb(buildingNumb);setLocalNumb(localNumb);

    }


    // Getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumb() {
        return this.buildingNumb;
    }

    public void setBuildingNumb(String buildingNumb) {
        this.buildingNumb = buildingNumb;
    }

    public String getLocalNumb() {
        return this.localNumb;
    }

    public void setLocalNumb(String localNumb) {
        this.localNumb = localNumb;
    }


    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // methods
    
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()==Address.class)
        {
            Address adr=(Address) obj;

            // check if local numb is null, because if it is we cannot use method equals()
            if(this.getLocalNumb()==null&&adr.getLocalNumb()==null)
            {
                if(adr.getCity().equals(this.getCity())&&adr.getPostalCode().equals(this.getPostalCode())&&adr.getStreet().equals(this.getStreet())&&adr.getBuildingNumb().equals(this.getBuildingNumb()))
                {
                    return true;
                }
                return false;
            }
            if(this.getLocalNumb()==null&&adr.getLocalNumb().equals(""))
            {
                if(adr.getCity().equals(this.getCity())&&adr.getPostalCode().equals(this.getPostalCode())&&adr.getStreet().equals(this.getStreet())&&adr.getBuildingNumb().equals(this.getBuildingNumb()))
                {
                    return true;
                }
                return false;
            }
            if(this.getLocalNumb().equals("")&&adr.getLocalNumb()==null)
            {
                if(adr.getCity().equals(this.getCity())&&adr.getPostalCode().equals(this.getPostalCode())&&adr.getStreet().equals(this.getStreet())&&adr.getBuildingNumb().equals(this.getBuildingNumb()))
                {
                    return true;
                }
                return false;
            }
            else
            {
                if(adr.getCity().equals(this.getCity())&&adr.getPostalCode().equals(this.getPostalCode())&&adr.getStreet().equals(this.getStreet())&&adr.getBuildingNumb().equals(this.getBuildingNumb())&&adr.getLocalNumb().equals(this.getLocalNumb()))
                {
                    return true;
                }
                return false;
            }
            

        } 
        else {
            return false;
        }
    }    
}
