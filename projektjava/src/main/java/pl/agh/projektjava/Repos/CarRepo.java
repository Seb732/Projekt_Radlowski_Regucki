package pl.agh.projektjava.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.Car;

@Repository
public interface CarRepo extends CrudRepository<Car,String>
{
    /**
     * Returns all cars with status "hired"
     * @return
     */
    @Query("SELECT c FROM Car c WHERE c.status='hired'")
    public Iterable<Car> getAllHiredCars();

    @Query("SELECT c FROM Car c WHERE c.status='available'")
    public Iterable<Car> getAllAvailable();

    
    @Query("SELECT a FROM Car as a WHERE a.registNumb=:regist")
    public Optional<Car> getCarByRegistNumb(@Param("regist") String regist);
}
