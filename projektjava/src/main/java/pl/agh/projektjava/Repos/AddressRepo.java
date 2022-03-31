package pl.agh.projektjava.Repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address,Long>
{
    /**
     * Returns all addresses in given city
     * @param city
     * @return
     */
    @Query("SELECT adr FROM Address adr WHERE adr.city=:city")
    public Iterable<Address> getAddressesByCity(@Param("city") String city);
}
