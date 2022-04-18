package pl.agh.projektjava.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Entities.Car;
import pl.agh.projektjava.Repos.CarRepo;

@Service
public class CarServices {

    @Autowired
    private CarRepo carRepo;

    public CarServices()
    {}

    /**
     * Returns all cars
     * @return
     */
    public Iterable<Car> getAll()
    {
        return carRepo.findAll();
    }

    /**
     * Returns all cars that have status "hired"
     * @return
     */
    public Iterable<Car> getAllHired()
    {
        return carRepo.getAllHiredCars();
    }

    /**
     * Returns all available cars
     * @return
     */
    public Iterable<Car> getAllAvailable()
    {
        return carRepo.getAllAvailable();
    }

    /**
     * Returns car with given registration number
     * @param registNumb
     * @return
     */
    public Optional<Car> getCarByRegistNumb(String registNumb)
    {
        return carRepo.getCarByRegistNumb(registNumb);
    }

    /**
     * Returns car with given vin
     * @param vin
     * @return
     */
    public Optional<Car> getCarByVin(String vin)
    {
        return carRepo.findById(vin);
    }

    /**
     * Delets car with given VIN
     * @param vin
     */
    public void deleteCarByVin(String vin)
    {
        carRepo.deleteById(vin);
    }

    /**
     * Saves car
     * @param car
     * @return
     */
    public Car saveCar(Car car)
    {
        return carRepo.save(car);
    }

    /**
     * Updates car information
     * @param car
     * @return
     */
    public Car updateCar(Car car)
    {
        return carRepo.save(car);
    }

    
}
