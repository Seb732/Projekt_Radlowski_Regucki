package pl.agh.projektjava.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address,Long>
{
    
}
