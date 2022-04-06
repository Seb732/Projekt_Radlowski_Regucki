package pl.agh.projektjava.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.Damage;

@Repository
public interface DamageRepo extends CrudRepository<Damage,Long>
{
    
}
