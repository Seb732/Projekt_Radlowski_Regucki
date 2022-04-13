package pl.agh.projektjava.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Entities.Address;
import pl.agh.projektjava.Repos.AddressRepo;

@Service
public class AddressServices {

    @Autowired
    private AddressRepo addressRepo;
    
    public AddressServices(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    /**
     * Returns all addresses
     * @return
     */
    public Iterable<Address> getAll()
    {
        return addressRepo.findAll();
    } 

    /**
     * Returns addresses in given city
     * @param city
     * @return
     */
    public Iterable<Address> getByCity(String city)
    {
        return addressRepo.getAddressesByCity(city);
    }

    /**
     * Saves given Address if not already existing
     * @param address
     * @return
     */
    public Address saveAddress(Address address)
    {
        Iterable<Address> all=getAll();
        for(Address adr : all)
        {
            if(adr.equals(address))
            {
                return adr;
            }
        }
        return addressRepo.save(address);
    }

    /**
     * Update car
     * @param address
     * @return
     */
    public Address updateAddress(Address address)
    {
        return addressRepo.save(address);
    }

    /**
     * Delete address
     * @param address
     */
    public void deleteById(Address address)
    {
        addressRepo.delete(address);
    }


    /**
     * Function checks if address is already in database. If it is, then returns its entity. If not saves object
     * @param address
     * @return
     */
    public Address saveIfNotInDB(Address address)
    {
        for(Address adr:getAll())
        {
            if(address.equals(adr))
            {
                return adr;
            }
        }
        
        return saveAddress(address);
    }

    
}
