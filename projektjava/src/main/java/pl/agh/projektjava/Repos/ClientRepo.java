package pl.agh.projektjava.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.Client;

@Repository
public interface ClientRepo<T extends Client> extends CrudRepository<T, Long>
{
    
}
