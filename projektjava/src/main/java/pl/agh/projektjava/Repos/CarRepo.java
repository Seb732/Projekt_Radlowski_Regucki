package pl.agh.projektjava.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.Car;

@Repository
public interface CarRepo extends CrudRepository<Car,Long>
{
    
}
